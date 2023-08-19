package com.example.cars.model;

public class Car {
    private int id;
    private String make;
    private String model;
    private int year;

    public Car(int i, String mk, String mod, int yr) {
        id = i;
        make = mk;
        model = mod;
        year = yr;
    }
    public int getId() {
        return id;
    }
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public void setId(int i) {
        id = i;
    }
    public void setMake(String mk) {
        make = mk;
    }
    public void setModel(String mod) {
        model = mod;
    }
    public void setYear(int yr) {
        year = yr;
    }
    @Override
    public String toString() {
        return "Car{}";
    }
}
