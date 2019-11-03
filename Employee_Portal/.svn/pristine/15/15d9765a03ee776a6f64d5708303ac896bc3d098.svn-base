package com.extremity.emp.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the emp_payslip database table.
 * 
 */
@Entity
@Table(name="emp_payslip")
@NamedQuery(name="EmpPayslip.findAll", query="SELECT e FROM EmpPayslip e")
public class EmpPayslip implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="payslip_id")
	private int payslipId;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="emp_id")
	private Employee employee;

	//bi-directional many-to-one association to BankDetail
	@ManyToOne
	@JoinColumn(name="emp_bank_id")
	private BankDetail bankDetail;

	//bi-directional many-to-one association to EmpLeave
	@ManyToOne
	@JoinColumn(name="emp_leave_id")
	private EmpLeave empLeave;

	//bi-directional many-to-one association to EmpPerksSalary
	@ManyToOne
	@JoinColumn(name="emp_sal_id")
	private EmpPerksSalary empPerksSalary;

	//bi-directional many-to-one association to EmpDeducation
	@ManyToOne
	@JoinColumn(name="emp_ded_id")
	private EmpDeducation empDeducation;

	public EmpPayslip() {
	}

	public int getPayslipId() {
		return this.payslipId;
	}

	public void setPayslipId(int payslipId) {
		this.payslipId = payslipId;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public BankDetail getBankDetail() {
		return this.bankDetail;
	}

	public void setBankDetail(BankDetail bankDetail) {
		this.bankDetail = bankDetail;
	}

	public EmpLeave getEmpLeave() {
		return this.empLeave;
	}

	public void setEmpLeave(EmpLeave empLeave) {
		this.empLeave = empLeave;
	}

	public EmpPerksSalary getEmpPerksSalary() {
		return this.empPerksSalary;
	}

	public void setEmpPerksSalary(EmpPerksSalary empPerksSalary) {
		this.empPerksSalary = empPerksSalary;
	}

	public EmpDeducation getEmpDeducation() {
		return this.empDeducation;
	}

	public void setEmpDeducation(EmpDeducation empDeducation) {
		this.empDeducation = empDeducation;
	}

}