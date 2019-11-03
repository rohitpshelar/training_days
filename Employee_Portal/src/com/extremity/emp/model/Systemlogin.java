package com.extremity.emp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the systemlogin database table.
 * 
 */
@Entity
@NamedQuery(name="Systemlogin.findAll", query="SELECT s FROM Systemlogin s")
public class Systemlogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int uId;

	private byte enabled;

	private String uName;

	private String uPass;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="systemlogin")
	private List<UserRole> userRoles;

	public Systemlogin() {
	}

	public int getUId() {
		return this.uId;
	}

	public void setUId(int uId) {
		this.uId = uId;
	}

	public byte getEnabled() {
		return this.enabled;
	}

	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}

	public String getUName() {
		return this.uName;
	}

	public void setUName(String uName) {
		this.uName = uName;
	}

	public String getUPass() {
		return this.uPass;
	}

	public void setUPass(String uPass) {
		this.uPass = uPass;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setSystemlogin(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setSystemlogin(null);

		return userRole;
	}

}