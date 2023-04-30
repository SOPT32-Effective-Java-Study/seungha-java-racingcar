package racingcar.repository;


import racingcar.domain.Car;
import java.util.List;

public interface CarRepository {
    void saveCars(List<Car> carList);

    void updatePosition(Car car);

    Car findCarByName(String carName);

    List<Car> findWinners();

    List<Car> findAllCars();
}
