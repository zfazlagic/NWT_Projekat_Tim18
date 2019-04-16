package com.service.entities;

public class UserActivity {


    private Long id;

    private Integer userId;

    private Integer carId;

    private Integer isRental;

    private Integer isReservation;


    public Long getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }


    public Integer getIsRental() {
        return isRental;
    }

    public void setIsRental(Integer isRental) {
        this.isRental = isRental;
    }

    public Integer getIsReservation() {
        return isReservation;
    }

    public void setIsReservation(Integer isReservation) {
        this.isReservation = isReservation;
    }


    protected UserActivity() {
    }

    public UserActivity(Integer userId, Integer carId, Integer isRental, Integer isReservation) {
        this.userId = userId;
        this.carId = carId;
        this.isRental = isRental;
        this.isReservation = isReservation;
    }

    @Override
    public String toString() {
        return String.format(
                "Activity[id=%d, userId='%d', carId='%d', isRental='%d', isReservation='%d']",
                id, userId, carId, isRental, isReservation);
    }

}

