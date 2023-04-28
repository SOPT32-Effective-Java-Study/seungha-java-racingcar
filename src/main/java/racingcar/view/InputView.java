package racingcar.view;

import racingcar.view.message.ErrorMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
사용자의 응답을 입력받음
 */
public class InputView {

    private final OutputView outputView = new OutputView();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String SEPARATOR = ",";
    private static final int CAR_NAME_LENGTH_LIMIT = 5;

    public String[] scanCarNames() throws IOException {
        outputView.printCarNameMessage();
        return separateInput(readInput());
    }

    public int scanAttempts(BufferedReader br) throws IOException {
        outputView.printAttemptsMessage();
        return Integer.parseInt(readInput());
    }

    private String[] separateInput(String inputString) {
        String[] carNames = inputString.split(SEPARATOR);
        Arrays.stream(carNames).forEach(carName -> validateCarNameLength(carName.length()));
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
