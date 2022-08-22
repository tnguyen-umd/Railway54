package TestingSystem_Assignment_2;
import java.time.LocalDate;

public class Account {
	int			id;
	private String		Email;
	private String		userName;
	private String		fullName;	
	private Department	department;//this is foreign key from Department class
	private Group[]		groups;
	private Position	position;
	private LocalDate	createDate;
	
	//encapsulate groups
	public void setGroups(Group[] newGroups) {
		groups=newGroups;
	}

	public Group[]  getGroups () {
		return groups;
	}
	
	//encapsulate fullName
	public void setName(String newName) {
		fullName=newName;
	}

	public String  getName () {
		return fullName;
	}
	
	//encapsulate ID
	public void setID(int newID) {
		id=newID;
	}
	
	public int  getID () {
		return id;
	}
	
	//encapsulate Email
	public void setEmail(String newEmail) {
		Email=newEmail;
	}

	public String  getEmail () {
		return Email;
	}
	
	//encapsulate userName
		public void setUserName(String newUserName) {
			userName=newUserName;
		}

	public String  getUserName () {
		return userName;}
	
	//encapsulate department
	public void setDepartment(Department newDepartment) {
		department=newDepartment;
	}

	public Department  getDepartment () {
		return department;}

	
	//encapsulate Position
	public void setPosition(Position newPosition) {
		position=newPosition;
	}

	public Position  getPosition() {
		return position;}
	
	//encapsulate createDate
	public void setCreateDate(LocalDate newCreateDate) {
		createDate=newCreateDate;
	}

	public LocalDate  getCreateDate() {
		return createDate;}
		
}
