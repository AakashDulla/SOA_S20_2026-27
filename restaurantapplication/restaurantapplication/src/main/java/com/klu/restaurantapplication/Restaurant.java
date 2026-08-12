package com.klu.restaurantapplication;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Restaurant {
	@Id
	int id;
	String name;
	String location;
	//getters, setters, toString(), constructors
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
	public Restaurant(int id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
