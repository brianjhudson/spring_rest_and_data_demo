package com.example.cars.controller;

import com.example.cars.model.User;
import com.example.cars.dao.UserDao;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDao userDao;
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        return userDao.getUserById(id);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userDao.getAllUsers();
    }
}
