package com.vti.entity;

import java.time.LocalDate;
import java.util.List;

public class Account {
	private int id;
	private String Email;
	private String userName;
	private String fullName;
	private Department department;
	private List<Group> groups;// gr1
	private Position position;
	private LocalDate createDate;

	public Account(int id, String email, String userName, String fullName, Department department, List<Group> groups,
			Position position, LocalDate createDate) {
		super();
		this.id = id;
		Email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.department = department;
		this.groups = groups;
		this.position = position;
		this.createDate = createDate;
	}

	// encapsulate fullName
	public void setName(String newName) {
		fullName = newName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public String getName() {
		return fullName;
	}

	// encapsulate ID
	public void setID(int newID) {
		id = newID;
	}

	public int getID() {
		return id;
	}

	// encapsulate Email
	public void setEmail(String newEmail) {
		Email = newEmail;
	}

	public String getEmail() {
		return Email;
	}

	// encapsulate userName
	public void setUserName(String newUserName) {
		userName = newUserName;
	}

	public String getUserName() {
		return userName;
	}

	// encapsulate department
	public void setDepartment(Department newDepartment) {
		department = newDepartment;
	}

	public Department getDepartment() {
		return department;
	}

	// encapsulate Position
	public void setPosition(Position newPosition) {
		position = newPosition;
	}

	public Position getPosition() {
		return position;
	}

	// encapsulate createDate
	public void setCreateDate(LocalDate newCreateDate) {
		createDate = newCreateDate;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", Email=" + Email + ", userName=" + userName + ", fullName=" + fullName
				+ ", department=" + department + ", groups=" + groups + ", position=" + position + ", createDate="
				+ createDate + "]";
	}

}
