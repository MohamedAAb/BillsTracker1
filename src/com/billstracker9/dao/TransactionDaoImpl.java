package com.billstracker9.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.billstracker9.entities.Account;
import com.billstracker9.entities.Transaction;
import com.billstracker9.entities.User;

/**
 * @author Mohamed Abouregila
 *
 */
public class TransactionDaoImpl implements TransactionDao {
	 final String persistenceUnitName = "billstracker9";

	@Override
	public int addTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		int result = 0;
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(transaction);    // insert into offices .....
						
			
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
	public List<Transaction> findTransactionsByAccount(Account account) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		EntityManagerFactory emf = null;
		EntityManager em = null;
		List<Transaction> accountTransactionsList=null;
		try {
			emf = Persistence.createEntityManagerFactory(persistenceUnitName);
			em = emf.createEntityManager();
			
			String stm = "SELECT t FROM Transaction t WHERE t.account = :givenAccount ";
			Query query = em.createQuery(stm);
			query.setParameter("givenAccount", account);
	
			accountTransactionsList = query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	
		return accountTransactionsList;
	
	}

	@Override
	public List<Transaction> findPastDueBills() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Transaction> findTransactionsByAccountInDueDateRange(List <Account> accountList, Date fromDueDate, Date toDueDate, User user) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = null;
		EntityManager em = null;
		List<Transaction> transactionsList=null;
		try {
			emf = Persistence.createEntityManagerFactory(persistenceUnitName);
			em = emf.createEntityManager();
			

		    String stm = "SELECT t FROM Transaction t JOIN t.account a  WHERE a.user = :givenUser AND a.balance<0 AND t.dueDate >= :givenFromDate  AND t.dueDate <= :givenToDate";

		      //String stm = "SELECT t FROM Transaction t WHERE t.account IN :givenAccountList AND t.dueDate > :givenFromDate  AND t.dueDate <= :givenToDate";
			Query query = em.createQuery(stm);
			//query.setParameter("givenAccountList", accountList);
			query.setParameter("givenUser", user);
			query.setParameter("givenFromDate", fromDueDate);
			query.setParameter("givenToDate", toDueDate);

			transactionsList = query.getResultList();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	
		return transactionsList;	
	}


	@Override
	public List<Transaction> findPastDueTransactions(Date today, User user) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = null;
		EntityManager em = null;
		List<Transaction> transactionsList=null;
		try {
			emf = Persistence.createEntityManagerFactory(persistenceUnitName);
			em = emf.createEntityManager();
			

		    String stm = "SELECT t FROM Transaction t JOIN t.account a  WHERE a.user = :givenUser AND t.dueDate <= :givenDueDate And a.balance<0";

		      //String stm = "SELECT t FROM Transaction t WHERE t.account IN :givenAccountList AND t.dueDate > :givenFromDate  AND t.dueDate <= :givenToDate";
			Query query = em.createQuery(stm);
			//query.setParameter("givenAccountList", accountList);
			query.setParameter("givenUser", user);
			query.setParameter("givenDueDate", today);

			transactionsList = query.getResultList();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	
		return transactionsList;
	}

}
