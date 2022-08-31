package TestingSystem_Assignment_2;

import java.time.LocalDate;
import java.util.List;

public class Group {// gr1
	int id;
	String name;
	LocalDate createDate;
	List<Account> accounts;// ac1

	public Group() {

	}

	// constructor for Group

	// constructor for Group only id, name, createDate
	public Group(int id, String name, LocalDate createDate) {
		this.id = id;
		this.name = name;
		this.createDate = createDate;
	}

	public Group(int id, String name, LocalDate createDate, List<Account> accounts) {
		this.id = id;
		this.name = name;
		this.createDate = createDate;
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", createDate=" + createDate + ", accounts=" + accounts + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
