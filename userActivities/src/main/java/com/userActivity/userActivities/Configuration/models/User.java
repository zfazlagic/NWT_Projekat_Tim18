package com.userActivity.userActivities.Configuration.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "userRole")
    @NotEmpty(message = "You must asign role to the user!")
    private String role;

    @Column(name = "username")
    @NotEmpty(message = "Username CANNOT be empty!")
    @Size(min = 5, max = 15, message = "Username must have more than 5  and less than 15 characters!")
    private String username;


    protected User() {}

    public User(String role, String username)
    {
        this.role = role;
        this.username = username;
    }

    // Get and Set Methods


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
