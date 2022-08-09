package daos;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    public static final String URL = "jdbc:mysql://localhost:3306/car";
    public static final String USER = "blue";
    public static final String PASS = "abc123";

    public static Connection getConnection(){
        try{
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

}
