package com.billstracker9.services;

import java.util.Calendar;
import java.util.List;

import com.billstracker9.dao.TransactionDaoImpl;
import com.billstracker9.entities.Account;
import com.billstracker9.entities.Transaction;
import com.billstracker9.entities.User;

public class TransactionService {
	private TransactionDaoImpl transactionDaoImpl = new TransactionDaoImpl();
	private AccountService accountService=new AccountService();
	private PayeeService payeeService=new PayeeService();

	public boolean addTransaction(Transaction transaction) {
		boolean result = false;
		
		result = transactionDaoImpl.addTransaction(transaction)==1;
		
		return result;
	}
	
	public boolean addTransaction(Transaction transaction, String payeeName, String accountNumber, User user) {
		boolean result = false;
		Account account=null;
		
		account=accountService.getAccountBynumber(accountNumber);
		if(account==null) {
			account=new Account(accountNumber, 0, user, payeeService.getPayeeByPayeeName(payeeName));
			accountService.addAcount(account);

		}
		
		//if the user didn't pay a bill, the new balance will be the new bill as per personal bills
		if(account.getBalance()<0 && transaction.getAmount()<0 ) {
			
			account.setBalance(transaction.getAmount());
		}else {
			account.setBalance(account.getBalance()+transaction.getAmount());

		}
		accountService.updateAcountBalance(account);
		transaction.setAccount(account);

		result = transactionDaoImpl.addTransaction(transaction)==1;
		
		return result;
	}
	
	public List<Transaction> getDueSoonBills(User user){
		
		Calendar from= Calendar.getInstance();
		Calendar to=Calendar.getInstance();
		to.add(Calendar.DAY_OF_MONTH, 5);
		System.out.println(from);
		//from.get
	
		List<Transaction> transactionList =transactionDaoImpl.findTransactionsByAccountInDueDateRange(null, from.getTime(), to.getTime(),user);
		
		return transactionList;
	}
	
	public List<Transaction>findPastDueTransactions(User user){
		return transactionDaoImpl.findPastDueTransactions(Calendar.getInstance().getTime(), user);
		
	}


}
