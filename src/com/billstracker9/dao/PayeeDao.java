package com.billstracker9.dao;

import java.util.List;

import com.billstracker9.entities.Payee;
import com.billstracker9.entities.User;

/**
 * @author Mohamed Abouregila
 *
 */
public interface PayeeDao {

	public int addPayee(Payee payee);
	public Payee getPayeeByPayeeName(String payeeName);
	public List<Payee> getAllPayee();
	public List<Payee> getPayeeByUser(User user);



}
