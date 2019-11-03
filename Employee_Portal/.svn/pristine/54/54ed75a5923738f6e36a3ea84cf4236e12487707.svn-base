package com.extremity.emp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the company_portal database table.
 * 
 */
@Entity
@Table(name="company_portal")
@NamedQuery(name="CompanyPortal.findAll", query="SELECT c FROM CompanyPortal c")
public class CompanyPortal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="emp_id")
	private int empId;

	@Column(name="emp_designation")
	private String empDesignation;

	@Temporal(TemporalType.DATE)
	@Column(name="emp_joining_date")
	private Date empJoiningDate;

	@Column(name="emp_name")
	private String empName;

	@Column(name="emp_team")
	private String empTeam;

	public CompanyPortal() {
	}

	public int getEmpId() {
		return this.empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpDesignation() {
		return this.empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public Date getEmpJoiningDate() {
		return this.empJoiningDate;
	}

	public void setEmpJoiningDate(Date empJoiningDate) {
		this.empJoiningDate = empJoiningDate;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpTeam() {
		return this.empTeam;
	}

	public void setEmpTeam(String empTeam) {
		this.empTeam = empTeam;
	}

}