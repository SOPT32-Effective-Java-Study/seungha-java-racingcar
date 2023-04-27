package racingcar.service;

import racingcar.repository.CarRepository;

public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void registerCars(String[] carNames) {

    }

    @Override
    public void runRound() {

    }
}
