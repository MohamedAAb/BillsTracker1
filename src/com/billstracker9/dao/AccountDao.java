package com.billstracker9.dao;

import java.util.List;

import com.billstracker9.entities.Account;
import com.billstracker9.entities.User;

/**
 * @author Mohamed Abouregila
 *
 */
public interface AccountDao {
	public int addAccount(Account account);
	public int updateAccountBalance(String accountNumber,double balance);

	public Account getAccountbyAccountNumber(String accountNumber);
	public List<Account>getAccountListByUser(User user);
}
