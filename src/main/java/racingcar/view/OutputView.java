package racingcar.view;

import racingcar.view.message.Message;

import java.util.List;

/*
터미널에 노출될 메시지 출
 */
public class OutputView {

    private static final String POSITION_SEPERATOR = "-";
    private static final String CARNAME_MARK = " : ";
    private static final String WINNER_MESSAGE_PREFIX = "최종 우승자 : ";
    private static final String CARNAME_SEPERATOR = ", ";


    public void printCarNameMessage() {
        print(Message.ASK_CAR_NAMES);
    }

    public void printAttemptsMessage() {
        print(Message.ASK_ATTEMPTS);
    }

    public void printRound(List<String> carNames) { // carNames나 carPositions 같은 파라미터만 입력받음
        for (String carName:
                carNames) {
            print(carName + CARNAME_MARK);
            printPosition(carNames.size());
        }
    }

    public void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            print(POSITION_SEPERATOR);
        }
        print("\n");
    }

    public void printWinner(List<String> carNames) {
        print(WINNER_MESSAGE_PREFIX);

        for (int i = 0; i < carNames.size(); i++) {
            if (i != carNames.size() - 1) {
                print(carNames.get(i) + CARNAME_SEPERATOR);
                continue;
            }
            print(carNames.get(i));
        }

        // carNames.stream().forEach(carName -> print(carName);
    }

    private void print(String message) {
        System.out.println(message);
    }
}
