package daos;

import models.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDao implements genericDao<Car>{
    Connection connection = new ConnectionFactory().getConnection();

    public Car getMakeAndModel(String make, String model){
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM car WHERE make=? AND model=?");
            ps.setString(1, make);
            ps.setString(2, model);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return extractCarFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

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
            ResultSet rs = stmt.executeQuery("SELECT * FROM car WHERE id=" + id);

            if(rs.next())
            {
                return extractCarFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List findAll() {
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM car");

            List cars = new ArrayList();

            while(rs.next()){
                Car car = extractCarFromResultSet(rs);
                cars.add(car);
            }
            return cars;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Boolean update(Car dto) {
        try{
            PreparedStatement ps = connection.prepareStatement("UPDATE car SET make=?, model=?, year=?, color=?, vin=?");
            ps.setString(1, dto.getMake());
            ps.setString(2, dto.getModel());
            ps.setInt(3, dto.getYear());
            ps.setString(4, dto.getColor());
            ps.setString(5, dto.getVin());
            int i = ps.executeUpdate();

            if(i == 1){
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Boolean create(Car dto) {
        try{
            PreparedStatement ps = connection.prepareStatement("INSERT INTO car VALUES (NULL, ?, ?, ?, ?, ?");
            ps.setString(1, dto.getMake());
            ps.setString(2, dto.getModel());
            ps.setInt(3, dto.getYear());
            ps.setString(4, dto.getColor());
            ps.setString(5, dto.getVin());
            int i = ps.executeUpdate();

            if(i == 1){
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Boolean delete(int id) {
        try{
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM car WHERE id=" +id);

            if(i == 1){
                return true;
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;

    }

}
