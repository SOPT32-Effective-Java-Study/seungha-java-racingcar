package racingcar.config;

import racingcar.controller.CarController;
import racingcar.controller.CarControllerImpl;
import racingcar.repository.CarRepository;
import racingcar.repository.CarRepositoryImpl;
import racingcar.service.CarService;
import racingcar.service.CarServiceImpl;
import racingcar.view.InputView;

public class AppConfig {

    public CarController getCarController() {
        return new CarControllerImpl(getCarService());
    }

    public CarService getCarService() {
        return new CarServiceImpl(getCarRepository());
    }

    public CarRepository getCarRepository() {
        return new CarRepositoryImpl();
    }
}
