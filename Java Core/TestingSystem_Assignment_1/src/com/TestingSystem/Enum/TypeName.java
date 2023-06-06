package com.TestingSystem.Enum;

public enum TypeName {
	TYPENAME_ESSAY("Essay"),
	TYPENAME_MUTIPLECHOICE("Mutiple Choice");
	
	private String typeName;
	
	TypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return typeName;
	}
}
