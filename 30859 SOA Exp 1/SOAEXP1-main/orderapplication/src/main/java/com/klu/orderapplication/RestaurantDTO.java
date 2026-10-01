package com.klu.orderapplication;

public class RestaurantDTO {
	int id;
	String name;
	String location;
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
		return "RestaurantDTO [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
	public RestaurantDTO(int id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}
	public RestaurantDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
