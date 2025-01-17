package racingcar.service;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;

import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void registerCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName: carNames) {
            carList.add(new Car(carName));
        }
        carRepository.saveCars(carList);
    }

    @Override
    public List<String> getWinners() {
        List<Car> foundWinners = carRepository.findWinners(); // 맨 처임에 차 register할 때 static 변수로 차 몇개인지 저장해놓는 로직 추가
        List<String> winnerNames = foundWinners.stream()
                .map(foundWinner -> foundWinner.getName())
                .collect(Collectors.toList());

        return winnerNames;
    }

    @Override
    public Map<String, Integer> runEachRound() {
        List<Car> carList = carRepository.findAllCars();
        Map<String, Integer> resultMap = new HashMap<>();

        for (Car car: carList) {
            goOrStop(car);
            resultMap.put(car.getName(), car.getPosition());
        }

        Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(resultMap);
        return unmodifiableMap;
    }

    private void goOrStop(Car car){

        if (pickNumberInRange(1, 9) >= 4) {
            carRepository.updatePosition(car);
        }
    }
}
