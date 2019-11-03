package com.extremity.emp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.NotEmpty;

@Entity
@Table(name = "company_portal.hr_details")
public class Hr_details {

	@Id
	@GeneratedValue
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	 @NotEmpty(message = "Username should not be blank.")
	private String username;
	 
	private String branch;
	 @NotEmpty(message = "Email should not be blank.")
	private String email;
	private String status;

	public Hr_details() {

	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public Hr_details(String username, String branch, String email,
			String status) {
		super();
		this.username = username;
		this.branch = branch;
		this.email = email;
		this.status = status;
	}
}
