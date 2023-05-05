package racingcar.controller;

import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.io.IOException;
import java.util.Map;

public class CarControllerImpl implements CarController {

    private final CarService carService;
    private final InputView inputView;
    private final OutputView outputView;

    public CarControllerImpl(CarService carService) {
        this.carService = carService;
        this.inputView = InputView.getInputview();
        this.outputView = OutputView.getOutputView();
    }

    public void startRace() throws IOException {
        carService.registerCars(inputView.scanCarNames());
        int attemps = inputView.scanAttempts();
        outputView.printRaceResultMessage();
        for (int i = 0; i < attemps; i++) {
            Map<String, Integer> resultMap = carService.runEachRound();
            outputView.printRound(resultMap);
        }
        outputView.printWinner(carService.getWinners());
    }
}
