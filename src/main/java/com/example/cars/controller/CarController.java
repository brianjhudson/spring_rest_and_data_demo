package com.example.cars.controller;

import com.example.cars.dao.CarDao;
import com.example.cars.model.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CarController {
    CarDao carDao;

    @GetMapping("/cars{id}")
    public Car getCarById(@PathVariable int id) {
        return carDao.getCarById(id);
    }
}
