import com.mysql.cj.jdbc.ConnectionImpl;
import daos.CarDao;
import daos.ConnectionFactory;
import models.Car;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        ConnectionFactory.getConnection();

    }
}
