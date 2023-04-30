package racingcar.service;

import java.util.List;
import java.util.Map;

public interface CarService {
    void registerCars(List<String> carNames);

    Map<String, Integer> runEachRound();

    List<String> getWinners();
}
