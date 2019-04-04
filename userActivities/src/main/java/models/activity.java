package models;

import javax.persistence.*;


@Entity
@Table(name = "activity")
public class activity {

    @OneToOne(mappedBy = "activityDetails")
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "userID")
//    @NotEmpty(message = "UserID can't be null.")
    private Integer userId;

    @Column(name = "carID")
//    @NotEmpty(message = "CarID can't be null.")
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
//    @NotEmpty(message = "isRental can't be null.")
    private Integer isRental;
    @Column(name = "isReservation")
//    @NotEmpty(message = "isReservation can't be null.")
    private Integer isReservation;

    protected activity() {}

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
