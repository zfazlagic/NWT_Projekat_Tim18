package com.service.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "userRole")
    private String role;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

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

    @Override
    public String toString() {
        return String.format(
          "User: " + this.username + " with role: " + this.role
        );
    }
}
