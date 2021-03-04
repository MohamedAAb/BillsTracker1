package com.billstracker9.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;


@Embeddable
public class AccountPK implements Serializable {
	
	
	private String accountNumber;	
	private double balance;
	private Date date;
	
	
	public AccountPK() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	



	public AccountPK(String accountNumber, double balance, Date date) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.date = date;
	}





	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}





	public double getBalance() {
		return balance;
	}





	public void setBalance(double balance) {
		this.balance = balance;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		return result;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountPK other = (AccountPK) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		return true;
	}





	@Override
	public String toString() {
		return "AccountPK [accountNumber=" + accountNumber + ", balance=" + balance + ", date=" + date + "]";
	}
	

	
	


}
