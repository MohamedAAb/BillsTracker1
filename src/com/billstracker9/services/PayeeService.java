package com.billstracker9.services;

import java.util.List;

import com.billstracker9.dao.PayeeDaoImpl;
import com.billstracker9.entities.Payee;

public class PayeeService {
	
private PayeeDaoImpl pyeeDaoImpl = new PayeeDaoImpl();
	
	public boolean addPayee(Payee payee) {
		boolean result = false;
		
		result = pyeeDaoImpl.addPayee(payee)==1;
		
		return result;
	}
	
	
	public Payee getPayeeByPayeeName(String payeeName) {
		Payee payee = pyeeDaoImpl.getPayeeByPayeeName(payeeName);
		
		return payee;
	}

	public List<Payee> getAllPayee() {
		// TODO Auto-generated method stub
		List<Payee> payeeList=pyeeDaoImpl.getAllPayee();
		return payeeList;
	}


}
