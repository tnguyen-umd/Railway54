package TestingSystem_Assignment_2;

import java.time.LocalDate;
import java.util.Arrays;

public class Group {
	int id;
	String name;
	LocalDate createDate;
	Account[] accounts;

	public Group() {

	}

	// constructor for Group
	public Group(int id, String name, Account[] accounts, LocalDate createDate) {
		this.id = id;
		this.name = name;
		this.accounts = accounts;
		this.createDate = createDate;
	}

	// constructor for Group only id, name, createDate
	public Group(int id, String name, LocalDate createDate) {
		this.id = id;
		this.name = name;
		this.createDate = createDate;
	}

	// encapsulate ID
	public void setID(int newID) {
		id = newID;
	}

	public int getID() {
		return id;
	}

	// encapsulate fullName
	public void setName(String newName) {
		name = newName;
	}

	public String getName() {
		return name;
	}

	// encapsulate Account[]
	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", createDate=" + createDate + ", accounts="
				+ Arrays.toString(accounts) + "]";
	}

}
