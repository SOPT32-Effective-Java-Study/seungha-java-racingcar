package racingcar.controller;

import racingcar.repository.CarRepository;
import racingcar.service.CarService;

public interface CarController {

    /*
    - 레이스 시작 메서드
    - inputview로부터 레이스에 필요한 값을 받아옴
    - outputview로 출력
     */
    void startRace();
}
