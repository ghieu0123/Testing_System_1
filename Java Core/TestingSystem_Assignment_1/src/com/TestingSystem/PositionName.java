package com.TestingSystem;

public enum PositionName {
	POSITION_DEV("Dev"),
	POSITION_TEST("Test"),
	POSITION_SCRUM_MASTER("Scrum Master");
	
	private String positionName;

	PositionName(String positionName) {
		this.positionName = positionName;
	}
	
	public String getPositionName() {
		return positionName;
	}
	

}
