package com.billstracker9.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.billstracker9.entities.User;

/**
 * @author Mohamed Abouregila
 *
 */
public class UserDaoImpl implements UserDao {
	 final String persistenceUnitName = "billstracker9";

	@Override
	public int addUser(User user) {                            
		
		
		

		
		int result = 0;
		// 1. Entity Manager Factory & Entity Manager

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {
			// 2. Transaction - Begin
			entityManager.getTransaction().begin();
			
			// 3. Execute transaction
			entityManager.persist(user);    // insert into offices .....
			
			// ADD MORE BUSINESS LOGIC
			
			// 4. Transaction - commit
			entityManager.getTransaction().commit();
			result = 1;
		}catch(Exception e ) {
			e.printStackTrace();
			result = 0;
		} finally {
			// 5. Close entity manager & entity manager factory

			entityManager.close();
			entityManagerFactory.close();
		}
		

		
		return result;
	}



	@Override
	public List<User> getAllUsers() {
		//1 connect
		//2 execute
		//3 disconnect
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		List<User> usersList = new ArrayList<User>();
		try {

			 emf = Persistence.createEntityManagerFactory(persistenceUnitName);
			 em = emf.createEntityManager();
	
			String statement = "SELECT u FROM User u";  // enum
			Query query = em.createQuery(statement);
			
			usersList = query.getResultList();

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		return usersList;
	}

	@Override
	public User findByUserEmail(String email) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = null;
		EntityManager em = null;
		User user=null;
		try {
			emf = Persistence.createEntityManagerFactory(persistenceUnitName);
			em = emf.createEntityManager();
			
			String stm = "SELECT u FROM User u WHERE u.email = :givenEmail ";
			Query query = em.createQuery(stm);
			query.setParameter("givenEmail", email);
			
 			user = (User) query.getSingleResult();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	
		return user;
	}

	@Override
	public User findBySessionId(String sessionId) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = null;
		EntityManager em = null;
		User user=null;
		try {
			emf = Persistence.createEntityManagerFactory(persistenceUnitName);
			em = emf.createEntityManager();
			
			String stm = "SELECT u FROM User u WHERE u.sessionId = :givenSessionId ";
			Query query = em.createQuery(stm);
			query.setParameter("givenSessionId", sessionId);
			if(!query.getResultList().isEmpty())
				user = (User) query.getSingleResult();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	
		return user;
	
	}
	
	@Override
	public int updateUserSessionId(String email, String sessionId) {
		// TODO Auto-generated method stub
		int result = 0;
		
		// 1. connect
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		
		// 2. execute
		
		// find the object that i want to update
		// using the setters update the properties of the object
		try {
			
			int userId=findByUserEmail(email).getUserId();
			User user=em.find(User.class, userId);
			if (user != null) {
			
				em.getTransaction().begin();
				
				user.setSessionId(sessionId);
				user.setEmail(user.getEmail());
				user.setfName(user.getfName());
				user.setlName(user.getlName());
				user.setPassword(user.getPassword());
				
				
				em.getTransaction().commit();
			    result = 1;
			}
		} catch(Exception e) {
			result = 0;
			e.printStackTrace();
		} finally {
			// 3. disconnect
			em.close();
			emf.close();
		}
		
		return result;
	}
}
















