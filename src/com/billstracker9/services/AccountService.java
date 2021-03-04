package com.billstracker9.services;

import com.billstracker9.dao.AccountDaoImpl;
import com.billstracker9.entities.Account;

public class AccountService {
	
private AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
	
	public boolean addAcount(Account account) {
		boolean result = false;
		
		result = accountDaoImpl.addAccount(account)==1;
		
		return result;
	}

	public Account getAccountBynumber(String accountNumber) {
		// TODO Auto-generated method stub
		Account account=null;
		try {
			account=accountDaoImpl.getAccountbyAccountNumber(accountNumber);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		return account;
		}
	}
	
	public boolean updateAcountBalance(Account account) {
		boolean result=false;
		
		result=accountDaoImpl.updateAccountBalance(account.getAccountNumber(), account.getBalance())==1;
		
		return result;
	}


}
