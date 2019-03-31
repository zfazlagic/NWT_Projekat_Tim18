package com.cars.model;

import javax.persistence.*;

@Entity
public class Cars {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String carName;
	private boolean isEditable;
	private boolean isDeletable;

	public Cars(String carName,boolean isEditable,boolean isDeletable){
		this.carName=carName;
		this.isEditable=isEditable;
		this.isDeletable=isDeletable;
	}

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
