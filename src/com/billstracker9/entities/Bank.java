package com.billstracker9.entities;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(
        name="Bank", 
        uniqueConstraints=
            @UniqueConstraint(columnNames={"bankId", "bankName","website"})
    )
public class Bank {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int bankId;
	
	@Basic
	@Column(name="bankName", nullable=false, unique=true)
	private String bankName;
	
	@Basic
	@Column(name="website", nullable=false)
	private String website;
	
	@ManyToMany
	private List<User> bankUsers;
	
	

	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bank(int bankId, String bankName, String website, List<User> bankUsers) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.website = website;
		this.bankUsers=bankUsers;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<User> getBankUsers() {
		return bankUsers;
	}

	public void setBankUsers(List<User> bankUsers) {
		this.bankUsers = bankUsers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bankId;
		result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
		result = prime * result + ((bankUsers == null) ? 0 : bankUsers.hashCode());
		result = prime * result + ((website == null) ? 0 : website.hashCode());
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
		Bank other = (Bank) obj;
		if (bankId != other.bankId)
			return false;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
		if (bankUsers == null) {
			if (other.bankUsers != null)
				return false;
		} else if (!bankUsers.equals(other.bankUsers))
			return false;
		if (website == null) {
			if (other.website != null)
				return false;
		} else if (!website.equals(other.website))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", website=" + website + ", bankUsers=" + bankUsers
				+ "]";
	}

	
	
	
	
	

}
