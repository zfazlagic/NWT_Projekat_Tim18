package models;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "activityDetails")
public class activityDetails {

    public Integer getId() {
        return id;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
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

    @Column(name = "beginDate", nullable = false)
    @NotEmpty(message = "Begin date can't be null.")
    private String beginDate;

    @Column(name = "endDate", nullable = false)
//    @NotEmpty(message = "End date can't be null.")

    private String endDate;

    @Column(name = "location", nullable = false)
//    @NotEmpty(message = "Location can't be null.")
    private String location;

    @Column(name = "activityId", nullable = false)
//    @NotEmpty(message = "Activity_id can't be null.")
    private Integer activityId;

  protected activityDetails() {}

  public activityDetails(String beginDate, String endDate, String location, Integer activityId){
      this.beginDate=beginDate;
      this.endDate=endDate;
      this.location=location;
      this.activityId=activityId;
  }

  @Override
    public String toString (){
      return String.format("Activity Details[id=%d, beginDate='%s', endDate='%1s', location='%s', activityId='%d']",
              id, beginDate, endDate, location, activityId);
  }
}
