package com.service.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "userdetails")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "firstName")
    private String firstname;

    @Column(name = "lastName")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "verified")
    private boolean verified;

    @Column(name = "userActivities")
    private Integer userActivity;

    @Column(name = "userId")
    private Long userId;

    protected UserDetails() {}

    public UserDetails(String firstname, String lastname, String email, Date createdAt, boolean verified, Integer userActivity, Long userId) {
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

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public Integer getUserActivity() {
        return userActivity;
    }

    public void setUserActivities(Integer userActivity) {
        this.userActivity = userActivity;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
