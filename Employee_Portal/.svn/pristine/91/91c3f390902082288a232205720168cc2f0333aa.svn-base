package com.extremity.emp.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the emp_address database table.
 * 
 */
@Entity
@Table(name="emp_address")
@NamedQuery(name="EmpAddress.findAll", query="SELECT e FROM EmpAddress e")
public class EmpAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="addr_id")
	private int addrId;

	private String city;

	private String country;

	private String state;

	public EmpAddress() {
	}

	public int getAddrId() {
		return this.addrId;
	}

	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}