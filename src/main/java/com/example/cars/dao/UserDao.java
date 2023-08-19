package com.example.cars.dao;

import com.example.cars.model.User;

import java.util.List;
public interface UserDao {
    boolean createUser(int id, String firstName, String lastName, String email, boolean hasCompletedSignup);
    List<User> getAllUsers();
    User getUserById(int id);
//    boolean updateUser(User user);
//    boolean deleteUser(User user);

}
