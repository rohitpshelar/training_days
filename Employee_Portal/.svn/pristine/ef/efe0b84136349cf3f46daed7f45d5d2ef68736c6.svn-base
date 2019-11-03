package com.extremity.emp.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the emp_register database table.
 * 
 */
@Entity
@Table(name="emp_register")
@NamedQuery(name="EmpRegister.findAll", query="SELECT e FROM EmpRegister e")
public class EmpRegister implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String dsg;

	private String email;

	private String name;

	private String pass;

	private String uname;

	public EmpRegister() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDsg() {
		return this.dsg;
	}

	public void setDsg(String dsg) {
		this.dsg = dsg;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

}