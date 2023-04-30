package racingcar.view;

import racingcar.view.message.ErrorMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/*
사용자의 응답을 입력받음
 */
public class InputView {

    private final OutputView outputView = new OutputView();
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
        for (int i = 0; i < carNames.size(); i++) {
            validateCarNameLength(carNames.get(i).length());
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

    private void validateCarNameLength(int carNameLength) {
        if (carNameLength > CAR_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_LENGTH);
        }
    }
}
