import daos.CarDao;
import models.Car;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        CarDao carDao = new CarDao();
        Car car = new Car();

        System.out.println(car.getId());
        System.out.println(car.getMake());

    }
}
