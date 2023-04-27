package racingcar.config;

import racingcar.repository.CarRepository;
import racingcar.repository.CarRepositoryImpl;
import racingcar.service.CarService;
import racingcar.service.CarServiceImpl;

public class AppConfig {
    public CarService getCarService() {
        return new CarServiceImpl(getCarRepository());
    }

    public CarRepository getCarRepository() {
        return new CarRepositoryImpl();
    }
}
