package org.agile.grenoble.gui;

import org.agile.grenoble.data.AnswersStorage;
import org.agile.grenoble.user.User;
import org.agile.grenoble.user.UserFactory;

public class UserRegistration {

	AnswersStorage iStorage = null ;
	
	public UserRegistration(AnswersStorage storage) {
		iStorage = storage ; 
	}

	public User createUser() {
		User user = UserFactory.getUser("LaurentT", iStorage) ;
		
		return user;
	}

}
