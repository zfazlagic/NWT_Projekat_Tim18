package com.service.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
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

    @Column(name = "password")
    @NotEmpty(message = "Password CANNOT be empty!")
    @Size(min = 7, max = 15, message = "Password must have more than 7  and less than 15 characters!")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user")
    private UserDetails userDetails;

    protected User() {}


    public User(String role, String username, String password)
    {
        this.role = role;
        this.username = username;
        this.password = password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public String toString() {
        return String.format(
          "User: " + this.username + " with role: " + this.role
        );
    }
}
