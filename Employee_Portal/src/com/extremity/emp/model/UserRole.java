package com.extremity.emp.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_roles database table.
 * 
 */
@Entity
@Table(name="user_roles")
@NamedQuery(name="UserRole.findAll", query="SELECT u FROM UserRole u")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_role_id")
	private int userRoleId;

	private String role;

	private String username;

	//bi-directional many-to-one association to Systemlogin
	@ManyToOne
	@JoinColumn(name="uId")
	private Systemlogin systemlogin;

	public UserRole() {
	}

	public int getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Systemlogin getSystemlogin() {
		return this.systemlogin;
	}

	public void setSystemlogin(Systemlogin systemlogin) {
		this.systemlogin = systemlogin;
	}

}