package com.billstracker9.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Account {

//	@EmbeddedId
//	AccountPK accountPK;
	
	@Id
	private String accountNumber;

	@Basic
	@Column(name="balance", nullable=false)
	private double balance;	
	
	@ManyToOne
	private User user;

	@ManyToOne
	private Payee payee;

	
	public Account () {
		super();
		// TODO Auto-generated constructor stub
	}





	public Account(String accountNumber, double balance, User user, Payee payee) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.user = user;
		this.payee = payee;
	}






	public String getAccountNumberK() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	public Payee getPayee() {
		return payee;
	}



	public void setPayee(Payee payee) {
		this.payee = payee;
	}


	

	public double getBalance() {
		return balance;
	}





	public void setBalance(double balance) {
		this.balance = balance;
	}





	public String getAccountNumber() {
		return accountNumber;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((payee == null) ? 0 : payee.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Account other = (Account) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (payee == null) {
			if (other.payee != null)
				return false;
		} else if (!payee.equals(other.payee))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", user=" + user + ", payee="
				+ payee + "]";
	}


	


	
	
	
	
	
	
	
}
