package com.userActivity.userActivities.Configuration.models;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "activity")
public class activity {

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userID", nullable = false)
     @NotNull(message = "UserID can't be null.")
    private Integer userId;

    @Column(name = "carID", nullable = false)
    @NotNull(message = "Car name cannot be null")

    private Integer carId;

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

    @Column(name = "isRental")
    @Min(value = 0 , message = "isRental can only be 0 or 1.")
    @Max(value = 1, message = "isRental can only be 0 or 1.")
    private Integer isRental;

   @Column(name = "isReservation")
   @Min(value = 0 , message = "isReservation can only be 0 or 1.")
   @Max(value = 1, message = "isReservation can only be 0 or 1.")
    private Integer isReservation;

    public activity() {}

    public activity(Integer userId, Integer carId, Integer isRental, Integer isReservation) {
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
