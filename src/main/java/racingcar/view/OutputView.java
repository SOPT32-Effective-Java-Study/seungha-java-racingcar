package racingcar.view;

import racingcar.view.message.Message;

import java.util.List;
import java.util.Map;

/*
터미널에 노출될 메시지 출
 */
public class OutputView {

    private static final String POSITION_MARK = "-";
    private static final String CARNAME_MARK = " : ";
    private static final String WINNER_MESSAGE_PREFIX = "최종 우승자 : ";
    private static final String CARNAME_SEPERATOR = ", ";


    public void printCarNameMessage() {
        println(Message.ASK_CAR_NAMES);
    }

    public void printAttemptsMessage() {
        println(Message.ASK_ATTEMPTS);
    }

    public void printRaceResultMessage() { println(Message.RACE_RESULT_MESSAGE); }


    public void printRound(Map<String, Integer> resultMap) {
        for (String carName: resultMap.keySet()) {
            print(carName + CARNAME_MARK);
            printPosition(resultMap.get(carName));
        }
        printNextLine();
    }

    public void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            print(POSITION_MARK);
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
    }

    private void println(String message) {
        System.out.println(message);
    }
    private void print(String message) {
        System.out.print(message);
    }
    private void printNextLine() { System.out.print("\n");}

}
