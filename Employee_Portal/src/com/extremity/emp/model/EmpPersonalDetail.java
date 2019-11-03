package com.extremity.emp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the emp_personal_details database table.
 * 
 */
@Entity
@Table(name="emp_personal_details")
@NamedQuery(name="EmpPersonalDetail.findAll", query="SELECT e FROM EmpPersonalDetail e")
public class EmpPersonalDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="empp_id")
	private int emppId;

	@Column(name="emp_addr_id")
	private int empAddrId;

	@Temporal(TemporalType.DATE)
	@Column(name="emp_dob")
	private Date empDob;

	@Column(name="emp_father_name")
	private String empFatherName;

	@Column(name="emp_gender")
	private String empGender;

	@Column(name="emp_mother_name")
	private String empMotherName;

	@Column(name="emp_nominee")
	private String empNominee;

	@Column(name="emp_spouse")
	private String empSpouse;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="emp_id")
	private Employee employee;

	//bi-directional many-to-one association to EmpContact
	@ManyToOne
	@JoinColumn(name="emp_ct_id")
	private EmpContact empContact;

	//bi-directional many-to-one association to BankDetail
	@ManyToOne
	@JoinColumn(name="emp_bank_id")
	private BankDetail bankDetail;

	//bi-directional many-to-one association to CompanyDetail
	@ManyToOne
	@JoinColumn(name="emp_company_id")
	private CompanyDetail companyDetail;

	public EmpPersonalDetail() {
	}

	public int getEmppId() {
		return this.emppId;
	}

	public void setEmppId(int emppId) {
		this.emppId = emppId;
	}

	public int getEmpAddrId() {
		return this.empAddrId;
	}

	public void setEmpAddrId(int empAddrId) {
		this.empAddrId = empAddrId;
	}

	public Date getEmpDob() {
		return this.empDob;
	}

	public void setEmpDob(Date empDob) {
		this.empDob = empDob;
	}

	public String getEmpFatherName() {
		return this.empFatherName;
	}

	public void setEmpFatherName(String empFatherName) {
		this.empFatherName = empFatherName;
	}

	public String getEmpGender() {
		return this.empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public String getEmpMotherName() {
		return this.empMotherName;
	}

	public void setEmpMotherName(String empMotherName) {
		this.empMotherName = empMotherName;
	}

	public String getEmpNominee() {
		return this.empNominee;
	}

	public void setEmpNominee(String empNominee) {
		this.empNominee = empNominee;
	}

	public String getEmpSpouse() {
		return this.empSpouse;
	}

	public void setEmpSpouse(String empSpouse) {
		this.empSpouse = empSpouse;
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

	public BankDetail getBankDetail() {
		return this.bankDetail;
	}

	public void setBankDetail(BankDetail bankDetail) {
		this.bankDetail = bankDetail;
	}

	public CompanyDetail getCompanyDetail() {
		return this.companyDetail;
	}

	public void setCompanyDetail(CompanyDetail companyDetail) {
		this.companyDetail = companyDetail;
	}

}