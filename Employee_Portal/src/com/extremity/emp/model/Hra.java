package com.extremity.emp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the hra database table.
 * 
 */
@Entity
@NamedQuery(name="Hra.findAll", query="SELECT h FROM Hra h")
public class Hra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int hid;

	private String city;

	@Column(name="emp_id")
	private String empId;

	@Column(name="finicial_year")
	private String finicialYear;

	@Temporal(TemporalType.TIMESTAMP)
	private Date from;

	private String landoflord;

	private String metro;

	@Column(name="rent_paid")
	private String rentPaid;

	private double to;

	public Hra() {
	}

	public int getHid() {
		return this.hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmpId() {
		return this.empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getFinicialYear() {
		return this.finicialYear;
	}

	public void setFinicialYear(String finicialYear) {
		this.finicialYear = finicialYear;
	}

	public Date getFrom() {
		return this.from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public String getLandoflord() {
		return this.landoflord;
	}

	public void setLandoflord(String landoflord) {
		this.landoflord = landoflord;
	}

	public String getMetro() {
		return this.metro;
	}

	public void setMetro(String metro) {
		this.metro = metro;
	}

	public String getRentPaid() {
		return this.rentPaid;
	}

	public void setRentPaid(String rentPaid) {
		this.rentPaid = rentPaid;
	}

	public double getTo() {
		return this.to;
	}

	public void setTo(double to) {
		this.to = to;
	}

}