package racingcar.domain;

import racingcar.view.message.ErrorMessage;

public class Car {
    private final String name;
    private int position = 0;

    private static final int CAR_NAME_LENGTH_LIMIT = 5;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    public void go() {
        ++this.position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public static void validateCarNameLength(int carNameLength) {
        if (carNameLength > CAR_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_LENGTH);
        }
    }
}
