package com.cars.model;

import javax.persistence.*;
import javax.validation.constraints.*;

public class User {

    @Id
    private Long id;

    @NotEmpty(message = "Username CANNOT be empty!")
    @Size(min = 5, max = 15, message = "Username must have more than 5  and less than 15 characters!")
    private String username;

    protected User(){}

    public User(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
