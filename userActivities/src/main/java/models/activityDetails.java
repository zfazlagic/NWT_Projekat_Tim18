package models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class activityDetails {

    public Integer getId() {
        return id;
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
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    private Date beginDate;
    private Date endDate;
    private String location;
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
      return String.format("Activity Details[id=%d, beginDate='%1$td.%1$tm.%1$ty', endDate='%1$td.%1$tm.%1$ty', location='%s', activityId='%d']",
              id, beginDate, endDate, location, activityId);
  }
}
