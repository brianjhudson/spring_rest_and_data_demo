package com.example.cars.model;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean hasCompletedSignup;

    public User(int i, String fn, String ln, String em, boolean hcs) {
        id = i;
        firstName = fn;
        lastName = ln;
        email = em;
        hasCompletedSignup = hcs;
    }
    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public boolean getHasCompletedSignup() {
        return hasCompletedSignup;
    }
    public void setId(int i) {
        id = i;
    }
    public void setFirstName(String fn) {
        firstName = fn;
    }
    public void setLastName(String ln) {
        lastName = ln;
    }
    public void setEmail(String em) {
        email = em;
    }
    public void setHasCompletedSignup(boolean hcs) {
        hasCompletedSignup = hcs;
    }
    @Override
    public String toString() {
        return "User{}";
    }
}
