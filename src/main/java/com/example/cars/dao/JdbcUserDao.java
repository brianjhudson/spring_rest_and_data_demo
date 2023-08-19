package com.example.cars.dao;

import com.example.cars.exception.DaoException;
import com.example.cars.model.User;
import com.example.cars.dao.UserDao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

@Component
public class JdbcUserDao implements UserDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jT) {
        jdbcTemplate = jT;
    }

    @Override
    public boolean createUser(int id, String firstName, String lastName, String email, boolean hasCompletedSignup) {
        String sql = "INSERT INTO users (id, first_name, last_name, email, has_completed_signup) VALUES (?, ?, ?, ?, ?)";
        boolean isSuccessful;

        try {
            isSuccessful = jdbcTemplate.update(sql, id, firstName, lastName, email, hasCompletedSignup) == 1;
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Cannot connect to database", e);
        }
        return isSuccessful;
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        String sql = "SELECT * FROM users WHERE id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                user = mapRowToUser(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to database", e);
        }
        return user;
    }
    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

            while(results.next()) {
                users.add(mapRowToUser(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to database", e);
        }
        return users;
    }

    private User mapRowToUser(SqlRowSet result) {
        return new User(
                result.getInt("id"),
                result.getString("first_name"),
                result.getString("last_name"),
                result.getString("email"),
                result.getBoolean("has_completed_signup")
        );
    }

}
