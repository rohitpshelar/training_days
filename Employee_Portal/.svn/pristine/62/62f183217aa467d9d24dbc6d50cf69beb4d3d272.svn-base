package com.extremity.emp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bank_details database table.
 * 
 */
@Entity
@Table(name="bank_details")
@NamedQuery(name="BankDetail.findAll", query="SELECT b FROM BankDetail b")
public class BankDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="b_id")
	private int bId;

	private String account;

	@Column(name="b_branch")
	private String bBranch;

	@Column(name="b_name")
	private String bName;

	@Column(name="b_phone")
	private String bPhone;

	private String ifsccode;

	//bi-directional many-to-one association to EmpPayslip
	@OneToMany(mappedBy="bankDetail")
	private List<EmpPayslip> empPayslips;

	//bi-directional many-to-one association to EmpPersonalDetail
	@OneToMany(mappedBy="bankDetail")
	private List<EmpPersonalDetail> empPersonalDetails;

	public BankDetail() {
	}

	public int getBId() {
		return this.bId;
	}

	public void setBId(int bId) {
		this.bId = bId;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getBBranch() {
		return this.bBranch;
	}

	public void setBBranch(String bBranch) {
		this.bBranch = bBranch;
	}

	public String getBName() {
		return this.bName;
	}

	public void setBName(String bName) {
		this.bName = bName;
	}

	public String getBPhone() {
		return this.bPhone;
	}

	public void setBPhone(String bPhone) {
		this.bPhone = bPhone;
	}

	public String getIfsccode() {
		return this.ifsccode;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

	public List<EmpPayslip> getEmpPayslips() {
		return this.empPayslips;
	}

	public void setEmpPayslips(List<EmpPayslip> empPayslips) {
		this.empPayslips = empPayslips;
	}

	public EmpPayslip addEmpPayslip(EmpPayslip empPayslip) {
		getEmpPayslips().add(empPayslip);
		empPayslip.setBankDetail(this);

		return empPayslip;
	}

	public EmpPayslip removeEmpPayslip(EmpPayslip empPayslip) {
		getEmpPayslips().remove(empPayslip);
		empPayslip.setBankDetail(null);

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
		empPersonalDetail.setBankDetail(this);

		return empPersonalDetail;
	}

	public EmpPersonalDetail removeEmpPersonalDetail(EmpPersonalDetail empPersonalDetail) {
		getEmpPersonalDetails().remove(empPersonalDetail);
		empPersonalDetail.setBankDetail(null);

		return empPersonalDetail;
	}

}