package com.billstracker9.dao;


import java.util.List;
import com.billstracker9.entities.User;

public interface UserDao {
	
	public int addUser(User user);
	//public int updateUser(int userId, User newUser);
	//public Offices deleteOffice(String officeCode);
	//public Offices getOfficeByOfficeCode (String officeCode);
	public List<User> getAllUsers();
	public User findByUserEmail(String email);
	public User findBySessionId(String sessionId);
	public int updateUserSessionId(String email, String sessionId);
	



}
