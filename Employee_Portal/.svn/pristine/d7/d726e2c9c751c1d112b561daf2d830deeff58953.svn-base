package com.extremity.emp.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the emp_attendence database table.
 * 
 */
@Entity
@Table(name="emp_attendence")
@NamedQuery(name="EmpAttendence.findAll", query="SELECT e FROM EmpAttendence e")
public class EmpAttendence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="att_id")
	private int attId;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="empid")
	private Employee employee;

	public EmpAttendence() {
	}

	public int getAttId() {
		return this.attId;
	}

	public void setAttId(int attId) {
		this.attId = attId;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}