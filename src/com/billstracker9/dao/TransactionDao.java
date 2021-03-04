package com.billstracker9.dao;

import java.util.Date;
import java.util.List;

import com.billstracker9.entities.Account;
import com.billstracker9.entities.Transaction;
import com.billstracker9.entities.User;

public interface TransactionDao {
	public int addTransaction(Transaction transaction);
	public List<Transaction> findTransactionsByAccount(Account account);
	public List<Transaction> findTransactionsByAccountInDueDateRange(List <Account> accountList, Date fromDate, Date toDate, User user);
	public List<Transaction> findPastDueTransactions( Date today, User user);

	public List<Transaction> findPastDueBills();
	


}
