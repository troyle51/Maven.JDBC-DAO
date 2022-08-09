package models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CarTest {


    @Test
    public void testCarGetId(){
        Car car = new Car();
        car.setId(1);
        int expected = car.getId();
        int actual = 1;

        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testCarGetMake(){
        Car car = new Car();
        car.setMake("Honda");
        String expected = car.getMake();
        String actual = "Honda";

        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testCarGetModel(){
        Car car = new Car();
        car.setModel("Civic");
        String expected = car.getModel();
        String actual = "Civic";

        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testCarGetYear(){
        Car car = new Car();
        car.setYear(1991);
        int expected = car.getYear();
        int actual = 1991;

        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testCarGetColor(){
        Car car = new Car();
        car.setColor("White");
        String expected = car.getColor();
        String actual = "White";

        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testCarGetVin(){
        Car car = new Car();
        car.setVin("Plate");
        String expected = car.getVin();
        String actual = "Plate";

        Assert.assertEquals(actual, expected);
    }
}
