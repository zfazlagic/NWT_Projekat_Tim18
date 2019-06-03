package com.service.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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

    @Column(name = "username")
    @NotEmpty(message = "Username CANNOT be empty!")
    @Size(min = 5, max = 15, message = "Username must have more than 5  and less than 15 characters!")
    private String username;

    @NotEmpty(message = "Field email cannot be empty!")
    @Column(name = "email")
    @Pattern(regexp = "^(?:(?:[\\w`~!#$%^&*\\-=+;:{}'|,?\\/]+(?:(?:\\.(?:\"(?:\\\\?[\\w`~!#$%^&*\\-=+;:{}'|,?\\/\\.()<>\\[\\] @]|\\\\\"|\\\\\\\\)*\"|[\\w`~!#$%^&*\\-=+;:{}'|,?\\/]+))*\\.[\\w`~!#$%^&*\\-=+;:{}'|,?\\/]+)?)|(?:\"(?:\\\\?[\\w`~!#$%^&*\\-=+;:{}'|,?\\/\\.()<>\\[\\] @]|\\\\\"|\\\\\\\\)+\"))@(?:[a-zA-Z\\d\\-]+(?:\\.[a-zA-Z\\d\\-]+)*|\\[\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\])$")
    private String email;

    @NotNull(message = "Field verified cannot be empty!")
    @Column(name = "verified")
    private Integer verified;


    @Column(name = "userActivities")
    private Long userActivity;

    @OneToOne(mappedBy = "userDetails")
    private User user;

    protected UserDetails() {
    }

    public UserDetails(String firstname, String lastname, String username, String email, int verified, Long userActivity) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.verified = verified;
        this.userActivity = userActivity;
    }

    // Get and Set Methods

    public String getUsername(){ return username;}

    public void setUsername(String username){ this.username = username;}

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


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
