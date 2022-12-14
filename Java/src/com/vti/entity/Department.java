package com.vti.entity;

public class Department {
	private int id;
	private String name;

	// Constructor for id and name
	public Department(int id, String name) {
		this.id = id;
		this.name = name;
	}

	// encapsulate ID
	public void setID(int newID) {
		id = newID;
	}

	public int getID() {
		return id;
	}

	// encapsulate Email
	public void setName(String newName) {
		name = newName;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

}
