package org.agile.grenoble.user;

import java.sql.SQLException;

import org.agile.grenoble.data.AnswersStorage;

public class UserFactory {

	public static User getUser(String pName, String userMail,AnswersStorage storage) {
		User iUser = null ; 
		try {
			iUser = storage.getorCreateUser(pName,userMail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			iUser = new User(); 
			e.printStackTrace();
		}
		
		return iUser ;
	}
	
}
