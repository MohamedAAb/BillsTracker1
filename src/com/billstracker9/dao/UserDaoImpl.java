package com.billstracker9.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.billstracker9.entities.User;

public class UserDaoImpl implements UserDao {
	 final String persistenceUnitName = "billstracker9";

	@Override
	public int addUser(User user) {                            // DML
		// 1. Entity Manager Factory & Entity Manager
		// 2. Transaction - Begin
		// 3. Execute transaction
		// 4. Transaction - commit
		// 5. Close entity manager & entity manager factory
		
		
		// ADD MORE BUSINESS LOGIC

		
		int result = 0;
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(user);    // insert into offices .....
			
			// ADD MORE BUSINESS LOGIC
			
			
			entityManager.getTransaction().commit();
			result = 1;
		}catch(Exception e ) {
			e.printStackTrace();
			result = 0;
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		

		
		return result;
	}

	/*
	@Override
	public int updateOffice(String officeCode, Offices newOffice) {
		int result = 0;
		
		// 1. connect
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		
		// 2. execute
		
		// find the object that i want to update
		// using the setters update the properties of the object
		try {
			Offices currentOffice = em.find(Offices.class, officeCode);
			
			if (currentOffice != null) {
			
				em.getTransaction().begin();
				
				currentOffice.setCity(newOffice.getCity());
				currentOffice.setAddressLine1(newOffice.getAddressLine1());
				currentOffice.setAddressLine2(newOffice.getAddressLine2());
				currentOffice.setCountry(newOffice.getCountry());
				currentOffice.setPhone(newOffice.getPhone());
				currentOffice.setPostalCode(newOffice.getPostalCode());
				currentOffice.setState(newOffice.getState());
				currentOffice.setTerritory(newOffice.getTerritory());
				
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

	@Override
	public Offices deleteOffice(String officeCode) {
		Offices officeDeleted = null;
		
		//1. connect
		//2. execute
		//3. disconnect
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			officeDeleted = em.find(Offices.class, officeCode);
			em.remove(officeDeleted);
			
			// business logic  (updating customer order, customer accounts, inventory, placing orders)

			
			
			em.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		return officeDeleted;
	}

	@Override
	public Offices getOfficeByOfficeCode(String officeCode) {
		Offices officeFound = null;
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		try {
			officeFound = em.find(Offices.class, officeCode);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}	
		return officeFound;
	}*/

	@Override
	public List<User> getAllUsers() {
		//1 connect
		//2 execute
		//3 disconnect
		
	//	List<Offices> officesList = new ArrayList<Offices>();
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
/*
	public List<Offices> getAllOfficesByCity(String city) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		List<Offices> officesList = new ArrayList<Offices>();
		try {
			emf = Persistence.createEntityManagerFactory(persistenceUnitName);
			em = emf.createEntityManager();
			
			String stm = "SELECT o FROM Offices o WHERE o.city = :givenCity ";
			Query query = em.createQuery(stm);
			query.setParameter("givenCity", city);
			 officesList = query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		return officesList;
	}*/
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
















