package models;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "activityDetails")
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "activityId")
    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "beginDate")
    @NotEmpty(message = "Begin date can't be null.")
    private Date beginDate;

    @Column(name = "endDate")
//    @NotEmpty(message = "End date can't be null.")

    private Date endDate;

    @Column(name = "location")
//    @NotEmpty(message = "Location can't be null.")
    private String location;

    @Column(name = "activityId")
//    @NotEmpty(message = "Activity_id can't be null.")
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
