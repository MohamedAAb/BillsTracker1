package com.billstracker9.entities;



import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;




@Entity
@Table(
        name="USER", 
        uniqueConstraints=
            @UniqueConstraint(columnNames={"userId", "email"})
    )
public class User {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	@Basic
	@Column(name="email", nullable=false, unique=true)
	private String email;
	
	@Basic
	@Column(name="fName", nullable=false)
	private String fName;
	
	@Basic
	@Column(name="lName", nullable=false)
	private String lName;
	
	@Basic
	@Column(name="password", nullable=false)
	private String password;
	
	@Basic
	@Column(name="sessionId")
	private String sessionId;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String email, String fName, String lName, String password) {
		super();
		this.userId = userId;
		this.email = email;
		this.fName = fName;
		this.lName = lName;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public User(int userId, String email, String fName, String lName, String password, String sessionId) {
		super();
		this.userId = userId;
		this.email = email;
		this.fName = fName;
		this.lName = lName;
		this.password = password;
		this.sessionId = sessionId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + ((lName == null) ? 0 : lName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((sessionId == null) ? 0 : sessionId.hashCode());
		result = prime * result + userId;
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (lName == null) {
			if (other.lName != null)
				return false;
		} else if (!lName.equals(other.lName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (sessionId == null) {
			if (other.sessionId != null)
				return false;
		} else if (!sessionId.equals(other.sessionId))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", fName=" + fName + ", lName=" + lName + ", password="
				+ password + ", sessionId=" + sessionId + "]";
	}
	
	
}
