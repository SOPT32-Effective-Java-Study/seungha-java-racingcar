package racingcar.view;

import racingcar.domain.Car;
import racingcar.view.message.ErrorMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class InputView {

    private InputView() {}

    public static InputView getInputview() {
        return inputView;
    }

    private static final InputView inputView = new InputView();
    private final OutputView outputView = OutputView.getOutputView();
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String SEPARATOR = ",";
    private static final int CAR_NAME_LENGTH_LIMIT = 5;

    public List<String> scanCarNames() throws IOException {
        outputView.printCarNameMessage();
        return separateInput(readInput());
    }

    public int scanAttempts() throws IOException {
        outputView.printAttemptsMessage();
        return Integer.parseInt(readInput());
    }

    private List<String> separateInput(String inputString) {
        List<String> carNames = List.of(inputString.split(SEPARATOR));
        for (String carName: carNames) {
            Car.validateCarNameLength(carName.length());
        }
        return carNames;
    }

    private String readInput() throws IOException {
        String inputString = br.readLine().trim();
        validateEmptyValue(inputString);
        return inputString;
    }

    private void validateEmptyValue(String inputString) {
        if (inputString == "") {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAME);
        }
    }
}
