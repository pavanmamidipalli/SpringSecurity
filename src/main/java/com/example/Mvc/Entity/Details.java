package com.example.Mvc.Entity;

public class Details {
	private int id;
	private String name;
	private String place;
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
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Details(int id, String name, String place) {
		super();
		this.id = id;
		this.name = name;
		this.place = place;
	}
	

}
