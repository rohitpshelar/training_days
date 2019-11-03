package com.extremity.emp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the emp_leave database table.
 * 
 */
@Entity
@Table(name="emp_leave")
@NamedQuery(name="EmpLeave.findAll", query="SELECT e FROM EmpLeave e")
public class EmpLeave implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="l_id")
	private int lId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date from;

	@Column(name="l_type")
	private String lType;

	@Column(name="no_day")
	private int noDay;

	private String reasons;

	@Column(name="report_manager_name")
	private String reportManagerName;

	@Temporal(TemporalType.TIMESTAMP)
	private Date to;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="emp_id")
	private Employee employee;

	//bi-directional many-to-one association to EmpContact
	@ManyToOne
	@JoinColumn(name="emp_ct_id")
	private EmpContact empContact;

	//bi-directional many-to-one association to EmpPayslip
	@OneToMany(mappedBy="empLeave")
	private List<EmpPayslip> empPayslips;

	public EmpLeave() {
	}

	public int getLId() {
		return this.lId;
	}

	public void setLId(int lId) {
		this.lId = lId;
	}

	public Date getFrom() {
		return this.from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public String getLType() {
		return this.lType;
	}

	public void setLType(String lType) {
		this.lType = lType;
	}

	public int getNoDay() {
		return this.noDay;
	}

	public void setNoDay(int noDay) {
		this.noDay = noDay;
	}

	public String getReasons() {
		return this.reasons;
	}

	public void setReasons(String reasons) {
		this.reasons = reasons;
	}

	public String getReportManagerName() {
		return this.reportManagerName;
	}

	public void setReportManagerName(String reportManagerName) {
		this.reportManagerName = reportManagerName;
	}

	public Date getTo() {
		return this.to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmpContact getEmpContact() {
		return this.empContact;
	}

	public void setEmpContact(EmpContact empContact) {
		this.empContact = empContact;
	}

	public List<EmpPayslip> getEmpPayslips() {
		return this.empPayslips;
	}

	public void setEmpPayslips(List<EmpPayslip> empPayslips) {
		this.empPayslips = empPayslips;
	}

	public EmpPayslip addEmpPayslip(EmpPayslip empPayslip) {
		getEmpPayslips().add(empPayslip);
		empPayslip.setEmpLeave(this);

		return empPayslip;
	}

	public EmpPayslip removeEmpPayslip(EmpPayslip empPayslip) {
		getEmpPayslips().remove(empPayslip);
		empPayslip.setEmpLeave(null);

		return empPayslip;
	}

}