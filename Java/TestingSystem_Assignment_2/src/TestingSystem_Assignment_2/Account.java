package TestingSystem_Assignment_2;

import java.time.LocalDate;
import java.util.Arrays;

public class Account {
	private int id;
	private String Email;
	private String userName;
	private String fullName;
	private Department department;
	private Group[] groups;
	private Position position;
	private LocalDate createDate;

	public Account(int id, String email, String userName, String fullName, Department department, Group[] groups,
			Position position, LocalDate createDate) {
		this.id = id;
		this.Email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.department = department;
		this.groups = groups;
		this.position = position;
		this.createDate = createDate;
	}

	// encapsulate groups
	public void setGroups(Group[] newGroups) {
		groups = newGroups;
	}

	public Group[] getGroups() {
		return groups;
	}

	// encapsulate fullName
	public void setName(String newName) {
		fullName = newName;
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
				+ ", department=" + department.getName() + ", groups=" + Arrays.toString(groups) + ", position="
				+ position + ", createDate=" + createDate + "]";
	}

}
