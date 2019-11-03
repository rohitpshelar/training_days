package com.extremity.emp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the attendance database table.
 * 
 */
@Entity
@NamedQuery(name="Attendance.findAll", query="SELECT a FROM Attendance a")
public class Attendance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="attendence_id")
	private int attendenceId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String present;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="emp_id")
	private Employee employee;

	public Attendance() {
	}

	public int getAttendenceId() {
		return this.attendenceId;
	}

	public void setAttendenceId(int attendenceId) {
		this.attendenceId = attendenceId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPresent() {
		return this.present;
	}

	public void setPresent(String present) {
		this.present = present;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}