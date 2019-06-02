package com.cars.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class CarDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Car brand cannot be null")
    private String brand;

    @NotNull(message = "Car model cannot be null")
    private String model;

    @NotNull(message = "Car year cannot be null")
    private int year;

    @NotNull(message = "Number of seats cannot be null")
    private int seatNumber;

    @NotNull(message = "Car description cannot be null")
    private String description;

    @NotNull(message = "Car type cannot be null")
    @Size(min = 5, max = 200, message = "Car type must be between 5 and 200 characters")
    private String carType;

    @NotNull(message = "Number of seats cannot be null")
    private double pricePerDay;

    @NotNull(message = "isAvailable field cannot be null")
    private boolean isAvailable;

    private String carImg;

    @NotNull(message = "Car ID cannot be null")
    private int carId;

    public CarDetails() {
    }

    public CarDetails(int id, @NotNull(message = "Car brand cannot be null") String brand, @NotNull(message = "Car model cannot be null") String model, @NotNull(message = "Car year cannot be null") int year, @NotNull(message = "Number of seats cannot be null") int seatNumber, @NotNull(message = "Car description cannot be null") String description, @NotNull(message = "Car type cannot be null") @Size(min = 5, max = 200, message = "Car type must be between 5 and 200 characters") String carType, @NotNull(message = "Number of seats cannot be null") double pricePerDay, @NotNull(message = "isAvailable field cannot be null") boolean isAvailable, String carImg, @NotNull(message = "Car ID cannot be null") int carId) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.seatNumber = seatNumber;
        this.description = description;
        this.carType = carType;
        this.pricePerDay = pricePerDay;
        this.isAvailable = isAvailable;
        this.carImg = carImg;
        this.carId = carId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getCarImg() {
        return carImg;
    }

    public void setCarImg(String carImg) {
        this.carImg = carImg;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }
}