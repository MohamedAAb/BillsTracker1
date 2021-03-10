package com.billstracker9.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.billstracker9.entities.Payee;
import com.billstracker9.entities.User;

/**
 * @author Mohamed Abouregila
 *
 */
public class PayeeDaoImpl implements PayeeDao {
	 final String persistenceUnitName = "billstracker9";


	@Override
	public int addPayee(Payee payee) {
		// TODO Auto-generated method stub
	int result = 0;
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(payee);    // insert into offices .....
			
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


	@Override
	public Payee getPayeeByPayeeName(String payeeName) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = null;
		EntityManager em = null;
		Payee foundPayee=null;
		try {
			emf = Persistence.createEntityManagerFactory(persistenceUnitName);
			em = emf.createEntityManager();
			
			String stm = "SELECT p FROM Payee p WHERE p.payeeName = :givenPayee ";
			Query query = em.createQuery(stm);
			query.setParameter("givenPayee", payeeName);
			if(!query.getResultList().isEmpty())
				foundPayee = (Payee) query.getSingleResult();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	
		return foundPayee;
	}

	@Override
	public List<Payee> getAllPayee() {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = null;
		EntityManager em = null;
		List<Payee>payeeList=null;
		try {
			emf = Persistence.createEntityManagerFactory(persistenceUnitName);
			em = emf.createEntityManager();
			
			String stm = "SELECT p FROM Payee p";
			Query query = em.createQuery(stm);
			
			payeeList =  query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	
		return payeeList;
	}


	@Override
	public List<Payee> getPayeeByUser(User user) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		List<Payee>payeeList=null;
		try {
			emf = Persistence.createEntityManagerFactory(persistenceUnitName);
			em = emf.createEntityManager();
			
			String stm = "SELECT p FROM Payee p where p.user = givenUser";
			Query query = em.createQuery(stm);
			query.setParameter("givenUser", user);
			payeeList =  query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	
		return payeeList;	}		

}
