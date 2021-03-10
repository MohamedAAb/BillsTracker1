package com.billstracker9.dao;


import java.util.List;
import com.billstracker9.entities.User;

/**
 * @author Mohamed Abouregila
 *
 */
public interface UserDao {
	
	public int addUser(User user);
	public List<User> getAllUsers();
	public User findByUserEmail(String email);
	public User findBySessionId(String sessionId);
	public int updateUserSessionId(String email, String sessionId);
	



}
