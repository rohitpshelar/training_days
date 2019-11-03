package com.extremity.emp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
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

	//bi-directional many-to-one association to Team
		@ManyToOne
		@JoinColumn(name="team_id")
		private Teams team;

	public Teams getTeam() {
			return team;
		}

		public void setTeam(Teams team) {
			this.team = team;
		}

	//bi-directional many-to-one association to Attendance
	@OneToMany(mappedBy="employee",cascade = CascadeType.ALL)
	private List<Attendance> attendances;

	//bi-directional many-to-one association to EmpAttendence
	@OneToMany(mappedBy="employee" ,cascade = CascadeType.ALL)
	private List<EmpAttendence> empAttendences;

	//bi-directional many-to-one association to EmpLeave
	@OneToMany(mappedBy="employee",cascade = CascadeType.ALL)
	private List<EmpLeave> empLeaves;

	//bi-directional many-to-one association to EmpPayslip
	@OneToMany(mappedBy="employee",cascade = CascadeType.ALL)
	private List<EmpPayslip> empPayslips;

	//bi-directional many-to-one association to EmpPersonalDetail
	@OneToMany(mappedBy="employee",cascade = CascadeType.ALL)
	private List<EmpPersonalDetail> empPersonalDetails;

	public Employee() {
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

	public List<Attendance> getAttendances() {
		return this.attendances;
	}

	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}

	public Attendance addAttendance(Attendance attendance) {
		getAttendances().add(attendance);
		attendance.setEmployee(this);

		return attendance;
	}

	public Attendance removeAttendance(Attendance attendance) {
		getAttendances().remove(attendance);
		attendance.setEmployee(null);

		return attendance;
	}

	public List<EmpAttendence> getEmpAttendences() {
		return this.empAttendences;
	}

	public void setEmpAttendences(List<EmpAttendence> empAttendences) {
		this.empAttendences = empAttendences;
	}

	public EmpAttendence addEmpAttendence(EmpAttendence empAttendence) {
		getEmpAttendences().add(empAttendence);
		empAttendence.setEmployee(this);

		return empAttendence;
	}

	public EmpAttendence removeEmpAttendence(EmpAttendence empAttendence) {
		getEmpAttendences().remove(empAttendence);
		empAttendence.setEmployee(null);

		return empAttendence;
	}

	public List<EmpLeave> getEmpLeaves() {
		return this.empLeaves;
	}

	public void setEmpLeaves(List<EmpLeave> empLeaves) {
		this.empLeaves = empLeaves;
	}

	public EmpLeave addEmpLeave(EmpLeave empLeave) {
		getEmpLeaves().add(empLeave);
		empLeave.setEmployee(this);

		return empLeave;
	}

	public EmpLeave removeEmpLeave(EmpLeave empLeave) {
		getEmpLeaves().remove(empLeave);
		empLeave.setEmployee(null);

		return empLeave;
	}

	public List<EmpPayslip> getEmpPayslips() {
		return this.empPayslips;
	}

	public void setEmpPayslips(List<EmpPayslip> empPayslips) {
		this.empPayslips = empPayslips;
	}

	public EmpPayslip addEmpPayslip(EmpPayslip empPayslip) {
		getEmpPayslips().add(empPayslip);
		empPayslip.setEmployee(this);

		return empPayslip;
	}

	public EmpPayslip removeEmpPayslip(EmpPayslip empPayslip) {
		getEmpPayslips().remove(empPayslip);
		empPayslip.setEmployee(null);

		return empPayslip;
	}

	public List<EmpPersonalDetail> getEmpPersonalDetails() {
		return this.empPersonalDetails;
	}

	public void setEmpPersonalDetails(List<EmpPersonalDetail> empPersonalDetails) {
		this.empPersonalDetails = empPersonalDetails;
	}

	public EmpPersonalDetail addEmpPersonalDetail(EmpPersonalDetail empPersonalDetail) {
		getEmpPersonalDetails().add(empPersonalDetail);
		empPersonalDetail.setEmployee(this);

		return empPersonalDetail;
	}

	public EmpPersonalDetail removeEmpPersonalDetail(EmpPersonalDetail empPersonalDetail) {
		getEmpPersonalDetails().remove(empPersonalDetail);
		empPersonalDetail.setEmployee(null);

		return empPersonalDetail;
	}

}