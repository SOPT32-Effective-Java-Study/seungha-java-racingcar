package racingcar;

import racingcar.config.AppConfig;
import racingcar.controller.CarController;

public class Application {
    public static void main(String[] args) {
        CarController carController = new AppConfig().getCarController();
        try {
            carController.startRace();
        } catch (Exception e){
            System.out.println("[ERROR]: " + e);
        }
    }
}
