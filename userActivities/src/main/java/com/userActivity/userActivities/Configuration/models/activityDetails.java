package com.userActivity.userActivities.Configuration.models;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "activityDetails")
public class activityDetails {

    public Long getId() {
        return detailId;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long detailId;

    @Column(name = "beginDate", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "beginDate can't be null.")
    private Date beginDate;

    @Column(name = "endDate", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "endDate can't be null.")
    private Date endDate;

    @Column(name = "location")
    @NotEmpty(message = "Location can't be empty.")
    @Size(min = 3, max = 15, message = "Location must be between 3 and 15 characters")
    @Pattern(regexp = "^[a-zA-Z]+[-_]*[a-zA-Z]", message = "Location only can contain letters")
    private String location;

    @Column(name = "activityId", nullable = false, unique=true)
    @NotNull(message = "Activity_id can't be null.")
    private Integer activityId;

  protected activityDetails() {}

  public activityDetails(Date beginDate, Date endDate, String location, Integer activityId){
      this.beginDate=beginDate;
      this.endDate=endDate;
      this.location=location;
      this.activityId=activityId;
  }

  @Override
    public String toString (){
      return String.format("Activity Details[id=%d, beginDate='%s', endDate='%1s', location='%s', activityId='%d']",
              detailId, beginDate, endDate, location, activityId);
  }
}
