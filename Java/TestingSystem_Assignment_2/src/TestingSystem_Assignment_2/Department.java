package TestingSystem_Assignment_2;

public class Department {
	private int		id;
	private String	name;
	
	
	
	//encapsulate ID
		public void setID(int newID) {
			id=newID;
		}
		
		public int  getID () {
			return id;
		}
		
		//encapsulate Email
		public void setName(String newName) {
			name=newName;
		}

		public String  getName () {
			return name;
		}
}
