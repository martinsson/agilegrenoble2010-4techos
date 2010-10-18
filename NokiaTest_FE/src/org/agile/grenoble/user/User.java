package org.agile.grenoble.user;

public class User {

	String  aName = "NO NAME";
	int anId  = -1 ;
	public User() {
		//initialize a new user
	}

	public void setName(String pName) {
		aName = pName ;
	}
	
	public void setId(int pId) {
		anId = pId ;
	}
	
	public String getName() {
		return aName; 
	}
	
	public int getId() {
		return anId ; 
	}
	
}
