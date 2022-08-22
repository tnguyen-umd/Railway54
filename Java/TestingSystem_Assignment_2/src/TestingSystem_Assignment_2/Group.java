package TestingSystem_Assignment_2;
import java.time.LocalDate;

public class Group {
	int		id;
	String	name;
	LocalDate	createDate;
	//Account[]	participants;
	
	//encapsulate ID
	public void setID(int newID) {
		id=newID;
	}

	public int  getID () {
		return id;
	}

	//encapsulate fullName
	public void setName(String newName) {
		name=newName;
	}

	public String  getName () {
		return name;
	}

}





