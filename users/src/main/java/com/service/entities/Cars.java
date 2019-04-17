package com.service.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Cars {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @NotNull(message = "Car name cannot be null")
    @Size(min = 1, max = 200, message = "Name must be between 5 and 200 characters")
    private String carName;

    public Cars(String carName){
        this.carName=carName;

    }
    public Cars(){}

    public String getCarName(){
        return this.carName;
    }
    public void setCarName(String value){
        this.carName=value;
    }
}
