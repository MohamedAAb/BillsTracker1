/**
 * 
 */
package com.billstracker9.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import com.billstracker9.dao.AccountDaoImpl;
import com.billstracker9.dao.PayeeDaoImpl;
import com.billstracker9.entities.Account;
import com.billstracker9.entities.AccountPK;
import com.billstracker9.entities.Payee;
import com.billstracker9.entities.User;
import com.billstracker9.services.UserServices;

/**
 * @author moham
 *
 */

@RunWith(Parameterized.class)
public class AccountDaoImplTest {
	
   final static String persistenceUnitName = "billstracker9";

	private String accountNumber;
	private Account expectedAccount;
	private Account accountToSave;
	private int expectedResult=0;
	static EntityManagerFactory emf = null;
	static EntityManager em = null;
	
	public AccountDaoImplTest(String accountNumber) {
		this.accountNumber=accountNumber;
	}
	
	@Parameterized.Parameters
	public static Collection param() {
		
		// connect to Test DB get the data from there....
		
		return Arrays.asList(new Object[]{"111111111-99","11111111-999", "11111111-09"});
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before Class");
		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		System.out.println("emf: "+emf);
		em = emf.createEntityManager();	
		System.out.println("em: "+em);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		em.close();
		emf.close();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("Set Up Before");
		
		expectedResult = 1;
		
		String stm = "SELECT a FROM Account a WHERE a.accountNumber = :givenAccountNumber ";
		Query query = em.createQuery(stm);
		query.setParameter("givenAccountNumber",accountNumber);
		
		expectedAccount = (Account)query.getSingleResult();
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.billstracker9.dao.AccountDaoImpl#addAccount(com.billstracker9.entities.Account)}.
	 */
	@Test
	public void testAddAccount() {
		
		AccountDaoImpl accountDaoImpl=new AccountDaoImpl();
		int actualResult=accountDaoImpl.addAccount(accountToSave);
		System.out.println("Test Started");
		assertEquals(expectedResult, actualResult);
		System.out.println("Test Ended");
	}

	/**
	 * Test method for {@link com.billstracker9.dao.AccountDaoImpl#getAccountbyAccountNumber(java.lang.String)}.
	 */
	@Test
	public void testGetAccountbyAccountNumber() {
		AccountDaoImpl accountDaoImpl=new AccountDaoImpl();
		//1 given
		//2 when
		Account actualAccount = accountDaoImpl.getAccountbyAccountNumber(accountNumber);
		//3 then
		System.out.println("Test Started");
		assertEquals(expectedAccount, actualAccount);
		System.out.println("Test Ended");
	}

}
