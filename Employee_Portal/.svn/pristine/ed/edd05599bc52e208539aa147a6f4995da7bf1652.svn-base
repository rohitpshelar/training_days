package com.extremity.emp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the emp_deducation database table.
 * 
 */
@Entity
@Table(name="emp_deducation")
@NamedQuery(name="EmpDeducation.findAll", query="SELECT e FROM EmpDeducation e")
public class EmpDeducation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="emp_ded_id")
	private int empDedId;

	@Column(name="insurance_ded")
	private double insuranceDed;

	@Column(name="pof_tax")
	private double pofTax;

	@Column(name="providenat_ded")
	private double providenatDed;

	@Column(name="total_ded")
	private double totalDed;

	//bi-directional many-to-one association to EmpPayslip
	@OneToMany(mappedBy="empDeducation")
	private List<EmpPayslip> empPayslips;

	public EmpDeducation() {
	}

	public int getEmpDedId() {
		return this.empDedId;
	}

	public void setEmpDedId(int empDedId) {
		this.empDedId = empDedId;
	}

	public double getInsuranceDed() {
		return this.insuranceDed;
	}

	public void setInsuranceDed(double insuranceDed) {
		this.insuranceDed = insuranceDed;
	}

	public double getPofTax() {
		return this.pofTax;
	}

	public void setPofTax(double pofTax) {
		this.pofTax = pofTax;
	}

	public double getProvidenatDed() {
		return this.providenatDed;
	}

	public void setProvidenatDed(double providenatDed) {
		this.providenatDed = providenatDed;
	}

	public double getTotalDed() {
		return this.totalDed;
	}

	public void setTotalDed(double totalDed) {
		this.totalDed = totalDed;
	}

	public List<EmpPayslip> getEmpPayslips() {
		return this.empPayslips;
	}

	public void setEmpPayslips(List<EmpPayslip> empPayslips) {
		this.empPayslips = empPayslips;
	}

	public EmpPayslip addEmpPayslip(EmpPayslip empPayslip) {
		getEmpPayslips().add(empPayslip);
		empPayslip.setEmpDeducation(this);

		return empPayslip;
	}

	public EmpPayslip removeEmpPayslip(EmpPayslip empPayslip) {
		getEmpPayslips().remove(empPayslip);
		empPayslip.setEmpDeducation(null);

		return empPayslip;
	}

}