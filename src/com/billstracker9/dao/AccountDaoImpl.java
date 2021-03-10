package com.billstracker9.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.billstracker9.entities.Account;
import com.billstracker9.entities.Payee;
import com.billstracker9.entities.User;

/**
 * @author Mohamed Abouregila
 *
 */
public class AccountDaoImpl implements AccountDao {
	 final String persistenceUnitName = "billstracker9";

	@Override
	public int addAccount(Account account) {
		int result = 0;
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(account);    // insert into offices .....
			
			
			
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

	@Override
	public Account getAccountbyAccountNumber(String accountNumber) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = null;
		EntityManager em = null;
		Account foundAccount=null;
		try {
			emf = Persistence.createEntityManagerFactory(persistenceUnitName);
			em = emf.createEntityManager();
			
			String stm = "SELECT a FROM Account a WHERE a.accountNumber = :givenAccountNumber ";
			Query query = em.createQuery(stm);
			query.setParameter("givenAccountNumber", accountNumber);
			
			//change to resultList and check if the list is empty
			if(!query.getResultList().isEmpty()) {
				foundAccount = (Account) query.getSingleResult();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
			return foundAccount;
		}
	
		
		
	}

	@Override
	public int updateAccountBalance(String accountNumber, double balance) {
		// TODO Auto-generated method stub
int result = 0;
		
		// 1. connect
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		
		// 2. execute
		
		// find the object that i want to update
		// using the setters update the properties of the object
		try {
			
			Account account=em.find(Account.class, accountNumber);
			if (account != null) {
			
				em.getTransaction().begin();
				
				account.setBalance(balance);
				
				
				
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
	public List<Account> getAccountListByUser(User user) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
