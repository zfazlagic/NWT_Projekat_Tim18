package com.cars.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class CarDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @NotNull(message = "Car name cannot be null")
    @Size(min = 1, max = 200, message = "Car name must be between 5 and 200 characters")
    private String carName;

    @NotNull(message = "Car type cannot be null")
    @Size(min = 5, max = 200, message = "Car type must be between 5 and 200 characters")
    private String carType;

    @NotNull(message = " Year model cannot be null")
    private int yearModel;

    @NotNull(message = "Licence cannot be null")
    // @Size(min = 5, max = 200, message = "Name must be between 5 and 200 characters")
    private String police;
    @NotNull(message = "Number of seats cannot be null")
    private  int numberOfSeats;

    @NotNull(message = "isAvailable field cannot be null")
    private boolean isAvailable;

    @NotNull(message = "Car ID cannot be null")
    private int carId;

    public CarDetails(){}

    public CarDetails(String carName, String carType, int yearModel, String police, int numberOfSeats, boolean isAvailable, int carId) {
        this.carName = carName;
        this.carType = carType;
        this.yearModel = yearModel;
        this.police = police;
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

    public void setPolice(String police) {
        this.police = police;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carId")
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

    public String getPolice() {
        return police;
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
