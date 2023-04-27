package racingcar.service;

public interface CarService {

    /*
    car 등록
     */
    void registerCars(String[] carNames);

    /*
    round 시작
    */
    void runRound();
}
