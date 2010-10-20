package org.agile.grenoble.user;

public class User {

	String  aName = "NO NAME";
	String anEmail = "NO MAIL";
	int anId  = -1 ;
	public User() {
		//initialize a new user
	}

	public void setEmail(String pEmail) {
		anEmail = pEmail;
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
	
	public String getEmail () {
		return anEmail;
	}
	
	public int getId() {
		return anId ; 
	}

	
}
