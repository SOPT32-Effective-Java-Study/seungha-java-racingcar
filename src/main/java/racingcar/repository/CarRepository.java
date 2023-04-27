package racingcar.repository;

public interface CarRepository {

    /*
    car 저장
     */
    void saveCars();

    /*
    round마다 car position 업데이트되는 부분 반영
     */
    void updatePosition();
}
