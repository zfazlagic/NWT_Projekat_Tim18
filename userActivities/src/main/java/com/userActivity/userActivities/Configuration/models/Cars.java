package com.userActivity.userActivities.Configuration.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @NotNull(message="Editable field cannot be null")
    private boolean isEditable;
    @NotNull(message="Deletable field cannot be null")
    private boolean isDeletable;

    public Cars(String carName,boolean isEditable,boolean isDeletable){
        this.carName=carName;
        this.isEditable=isEditable;
        this.isDeletable=isDeletable;
    }
    public Cars(){}

    public String getCarName(){
        return this.carName;
    }
    public void setCarName(String value){
        this.carName=value;
    }

    public boolean getEditable(){
        return this.isEditable;
    }
    public void setEditable(boolean value){
        this.isEditable=value;
    }

    public boolean getDeletable(){
        return this.isDeletable;
    }
    public void setDeletable(boolean value){
        this.isDeletable=value;
    }


}
