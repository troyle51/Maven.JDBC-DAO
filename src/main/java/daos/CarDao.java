package daos;

import models.Car;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CarDao implements genericDao<Car>{
    Connection connection = new ConnectionFactory().getConnection();

    public Car extractCarFromResultSet(ResultSet rs) throws SQLException{
        Car car = new Car();

        car.setId(rs.getInt("id"));
        car.setMake( rs.getString("name"));
        car.setModel( rs.getString("model"));
        car.setYear( rs.getInt("year"));
        car.setColor( rs.getString("color"));
        car.setVin( rs.getString("vin"));

        return car;
    }

    public Car findById(int id) {
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE id=" + id);

            if(rs.next())
            {
                Car car  = new Car();

                car.setId(rs.getInt("id"));
                car.setMake( rs.getString("name"));
                car.setModel( rs.getString("model"));
                car.setYear( rs.getInt("year"));
                car.setColor( rs.getString("color"));
                car.setVin( rs.getString("vin"));

                return car;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List findAll() {
        return null;
    }

    public Car update(Car dto) {
        return null;
    }

    public Car create(Car dto) {
        return null;
    }

    public void delete(int id) {

    }

}
