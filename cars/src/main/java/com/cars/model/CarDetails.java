package com.cars.model;

import javax.persistence.*;

@Entity
public class CarDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String carName;
    private String carType;
    private int yearModel;
    private String licence;
    private  int numberOfSeats;
    private boolean isAvailable;
    private int carId;


    public CarDetails(String carName, String carType, int yearModel, String licence, int numberOfSeats, boolean isAvailable, int carId) {
        this.carName = carName;
        this.carType = carType;
        this.yearModel = yearModel;
        this.licence = licence;
        this.numberOfSeats = numberOfSeats;
        this.isAvailable = isAvailable;
        this.carId = carId;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public void setYearModel(int yearModel) {
        this.yearModel = yearModel;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }



    public int getId() {
        return id;
    }

    public String getCarName() {
        return carName;
    }

    public String getCarType() {
        return carType;
    }

    public int getYearModel() {
        return yearModel;
    }

    public String getLicence() {
        return licence;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getCarId() {
        return carId;
    }




}
