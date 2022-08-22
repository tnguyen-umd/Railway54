package TestingSystem_Assignment_2;

public class Position {
	private int 			id;
	private PositionName	isPosition;
	
	
	//encapsulate ID
		public void setID(int newID) {
			id=newID;
		}
		
		public int  getID () {
			return id;
		}
		
		//encapsulate Email
		public void setPositionName(PositionName newPositionName) {
			isPosition=newPositionName;
		}

		public PositionName  getPositionName () {
			return isPosition;
		}
}
