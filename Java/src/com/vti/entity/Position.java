package com.vti.entity;

public class Position {
	private int 			id;
	private PositionName	isPosition;
	
	
	//constructor for id and isPosition
	public Position(int id, PositionName isPosition) {
		super();
		this.id = id;
		this.isPosition = isPosition;
	}

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
