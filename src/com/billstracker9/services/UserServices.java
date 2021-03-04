package com.billstracker9.services;

import com.billstracker9.dao.UserDaoImpl;
import com.billstracker9.entities.User;

public class UserServices {
	private UserDaoImpl userDao = new UserDaoImpl();
	
	public boolean addUser(User user) {
		boolean result = false;
		
		result = userDao.addUser(user)==1;
		
		return result;
	}

	
	public User getUserByEmail(String email) {
		// business logic
		User user = userDao.findByUserEmail(email);
		// business logic
		return user;
	}
	
	public User getUserBySessionId(String sessionId) {
		// business logic
		User user = userDao.findBySessionId(sessionId);
		// business logic
		return user;
	}
	
	public boolean updateSessionId(String email,String sessionId) {
		boolean result=false;
		result=userDao.updateUserSessionId(email, sessionId)==1;
		return result;
	}
	
	
	

}
