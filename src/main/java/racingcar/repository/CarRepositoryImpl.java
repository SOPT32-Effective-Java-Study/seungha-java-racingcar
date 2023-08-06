package racingcar.repository;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepositoryImpl implements CarRepository{

    private static List<Car> carList = new ArrayList<>();

    @Override
    public void saveCars(List<Car> carList) {
        this.carList = List.copyOf(carList);
    }

    @Override
    public void updatePosition(Car car) {
        car.go();
    }

    @Override
    public List<Car> findAllCars() {
        return carList;
    }

    @Override
    public List<Car> findWinners() {
        Car winner = carList
                .stream()
                .max(Comparator.comparing(Car::getPosition))
                .get();

        List<Car> winners = carList
                .stream()
                .filter(car -> car.getPosition() == winner.getPosition())
                .collect(Collectors.toList());

        return winners;
    }

    @Override
    public Car findCarByName(String carName) {
        return carList.stream()
                .filter(car -> car.getName().equals(carName))
                .findFirst()
                .get();
    }

}
