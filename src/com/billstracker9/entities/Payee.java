package com.billstracker9.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payee {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Basic
	@Column(name="payeeName", nullable=false, unique=true)
	private String payeeName;
	
	@Basic
	@Column(name="billType")
	private String billType;
	
	@Column(name="service")
	private String service;
	
	@Basic
	@Column(name="website", nullable=false)
	private String website;
	
	public Payee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payee(int id, String payeeName, String billType, String service, String website) {
		super();
		this.id = id;
		this.payeeName = payeeName;
		this.billType = billType;
		this.service = service;
		this.website = website;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billType == null) ? 0 : billType.hashCode());
		result = prime * result + id;
		result = prime * result + ((payeeName == null) ? 0 : payeeName.hashCode());
		result = prime * result + ((service == null) ? 0 : service.hashCode());
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
		Payee other = (Payee) obj;
		if (billType == null) {
			if (other.billType != null)
				return false;
		} else if (!billType.equals(other.billType))
			return false;
		if (id != other.id)
			return false;
		if (payeeName == null) {
			if (other.payeeName != null)
				return false;
		} else if (!payeeName.equals(other.payeeName))
			return false;
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service.equals(other.service))
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
		return "Payee [id=" + id + ", payeeName=" + payeeName + ", billType=" + billType + ", service="
				+ service + ", website=" + website + "]";
	}
	
	
	
	
}
