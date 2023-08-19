package com.example.cars.dao;

import com.example.cars.model.Car;

import java.util.List;
public interface CarDao {
    boolean createCar(int id, String make, String model, int year);
    List<Car> getAllCars();
    Car getCarById(int id);
    boolean updateCar(Car car);
    boolean deleteCar(Car car);

}
