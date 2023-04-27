package racingcar.controller;

import racingcar.service.CarService;

public class CarControllerImpl implements CarController {

    private final CarService carService;

    public CarControllerImpl(CarService carService) {
        this.carService = carService;
    }

    public void startRace() {

    }
}
