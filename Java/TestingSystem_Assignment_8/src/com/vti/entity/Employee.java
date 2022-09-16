package com.vti.entity;

import java.util.List;

public class Employee<T extends Number> {
	private static int counter = 1;
	private int id;
	private String name;
	private List<T> salaries;

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

	public List<T> getSalaries() {
		return salaries;
	}

	public void setSalaries(List<T> salaries) {
		this.salaries = salaries;
	}

	public Employee(String name, List<T> salaries) {
		super();
		this.id = counter;
		this.name = name;
		this.salaries = salaries;
		counter++;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salaries=" + salaries + "]";
	}

}

/*
 * Question 5: E generic 3 Tạo 1 class Employee có property id, name, salaries
 * với salaries là lương các tháng của Employee đó và là 1 array có data type có
 * thể là int, long, float.
 * 
 * Viết method trong Employee để in ra thông tin của Employee bao gồm id, name,
 * salaris.
 * 
 * Viết method trong Employee để in ra thông tin tháng lương cuối cùng của
 * Employee
 */