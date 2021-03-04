package com.billstracker9.entities;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity 
@Table(
	    uniqueConstraints=
	        @UniqueConstraint(columnNames={"transactionDate", "amount"})
	)
public class Transaction {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int transactionId;
	
	@Basic
	@Column(name="amount", nullable=false)
	private double amount;
	
	@Basic
	@Column(name="describtion")
	private String describtion;
	
	@Basic
	@Column(name="transactionDate", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date transactionDate;
	
	@Basic
	@Column(name="dueDate", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dueDate;
	

	
	@ManyToOne
	private Account account;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Transaction(int transactionId, double amount, Date transactionDate, Date dueDate, String describtion, Account account) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.dueDate = dueDate;
		this.describtion= describtion;
		this.account = account;
	}



	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	

	public Date getTransactionDate() {
		return transactionDate;
	}



	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}



	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	

	public String getDescribtion() {
		return describtion;
	}



	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}



	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}






	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((describtion == null) ? 0 : describtion.hashCode());
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
		result = prime * result + transactionId;
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
		Transaction other = (Transaction) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (describtion == null) {
			if (other.describtion != null)
				return false;
		} else if (!describtion.equals(other.describtion))
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
			return false;
		if (transactionId != other.transactionId)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", amount=" + amount + ", transactionDate="
				+ transactionDate + ", dueDate=" + dueDate + ", describtion=" + describtion+ ", account=" + account + "]";
	}
	
	

	
	
	
}
