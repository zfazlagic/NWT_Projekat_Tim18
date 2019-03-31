package com.service.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "userdetails")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Field firstname cannot be empty!")
    @Column(name = "firstName")
    private String firstname;

    @NotEmpty(message = "Field lastname cannot be empty!")
    @Column(name = "lastName")
    private String lastname;

    @NotEmpty(message = "Field email cannot be empty!")
    @Column(name = "email")
    @Pattern(regexp = "^(?:(?:[\\w`~!#$%^&*\\-=+;:{}'|,?\\/]+(?:(?:\\.(?:\"(?:\\\\?[\\w`~!#$%^&*\\-=+;:{}'|,?\\/\\.()<>\\[\\] @]|\\\\\"|\\\\\\\\)*\"|[\\w`~!#$%^&*\\-=+;:{}'|,?\\/]+))*\\.[\\w`~!#$%^&*\\-=+;:{}'|,?\\/]+)?)|(?:\"(?:\\\\?[\\w`~!#$%^&*\\-=+;:{}'|,?\\/\\.()<>\\[\\] @]|\\\\\"|\\\\\\\\)+\"))@(?:[a-zA-Z\\d\\-]+(?:\\.[a-zA-Z\\d\\-]+)*|\\[\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\])$")
    private String email;

    @NotEmpty(message = "Field createdAt cannot be empty!")
    @Column(name = "createdAt")
    private Date createdAt;

    @NotEmpty(message = "Field verified cannot be empty!")
    @Column(name = "verified")
    private Integer verified;

    @NotEmpty(message = "Field userActivities cannot be empty!")
    @Column(name = "userActivities")
    private Long userActivity;

    @NotEmpty(message = "Field userId cannot be empty!")
    @Column(name = "userId")
    private Long userId;

    protected UserDetails() {}

    public UserDetails(String firstname, String lastname, String email, Date createdAt, int verified, Long userActivity, Long userId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.createdAt = createdAt;
        this.verified = verified;
        this.userActivity = userActivity;
        this.userId = userId;
    }

    // Get and Set Methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer isVerified() {
        return verified;
    }

    public void setVerified(Integer verified) {
        this.verified = verified;
    }

    public Long getUserActivity() {
        return userActivity;
    }

    public void setUserActivities(Long userActivity) {
        this.userActivity = userActivity;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
