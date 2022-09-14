package com.vti.entity;

public class Student {

	// this is how to do auto increment
	private static int count = 1;
	private int id;
	private String name;

	public Student(String name) {
		super();

		id = count;
		this.name = name;
		count++;
	}

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

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

}
