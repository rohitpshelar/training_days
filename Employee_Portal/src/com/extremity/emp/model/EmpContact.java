package com.extremity.emp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the emp_contact database table.
 * 
 */
@Entity
@Table(name="emp_contact")
@NamedQuery(name="EmpContact.findAll", query="SELECT e FROM EmpContact e")
public class EmpContact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ct_id")
	private int ctId;

	private String email;

	@Lob
	@Column(name="emp_photo")
	private byte[] empPhoto;

	private String mobile;

	//bi-directional many-to-one association to EmpLeave
	@OneToMany(mappedBy="empContact")
	private List<EmpLeave> empLeaves;

	//bi-directional many-to-one association to EmpPersonalDetail
	@OneToMany(mappedBy="empContact")
	private List<EmpPersonalDetail> empPersonalDetails;

	//bi-directional many-to-one association to EmpResume
	@OneToMany(mappedBy="empContact")
	private List<EmpResume> empResumes;

	public EmpContact() {
	}

	public int getCtId() {
		return this.ctId;
	}

	public void setCtId(int ctId) {
		this.ctId = ctId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getEmpPhoto() {
		return this.empPhoto;
	}

	public void setEmpPhoto(byte[] empPhoto) {
		this.empPhoto = empPhoto;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<EmpLeave> getEmpLeaves() {
		return this.empLeaves;
	}

	public void setEmpLeaves(List<EmpLeave> empLeaves) {
		this.empLeaves = empLeaves;
	}

	public EmpLeave addEmpLeave(EmpLeave empLeave) {
		getEmpLeaves().add(empLeave);
		empLeave.setEmpContact(this);

		return empLeave;
	}

	public EmpLeave removeEmpLeave(EmpLeave empLeave) {
		getEmpLeaves().remove(empLeave);
		empLeave.setEmpContact(null);

		return empLeave;
	}

	public List<EmpPersonalDetail> getEmpPersonalDetails() {
		return this.empPersonalDetails;
	}

	public void setEmpPersonalDetails(List<EmpPersonalDetail> empPersonalDetails) {
		this.empPersonalDetails = empPersonalDetails;
	}

	public EmpPersonalDetail addEmpPersonalDetail(EmpPersonalDetail empPersonalDetail) {
		getEmpPersonalDetails().add(empPersonalDetail);
		empPersonalDetail.setEmpContact(this);

		return empPersonalDetail;
	}

	public EmpPersonalDetail removeEmpPersonalDetail(EmpPersonalDetail empPersonalDetail) {
		getEmpPersonalDetails().remove(empPersonalDetail);
		empPersonalDetail.setEmpContact(null);

		return empPersonalDetail;
	}

	public List<EmpResume> getEmpResumes() {
		return this.empResumes;
	}

	public void setEmpResumes(List<EmpResume> empResumes) {
		this.empResumes = empResumes;
	}

	public EmpResume addEmpResume(EmpResume empResume) {
		getEmpResumes().add(empResume);
		empResume.setEmpContact(this);

		return empResume;
	}

	public EmpResume removeEmpResume(EmpResume empResume) {
		getEmpResumes().remove(empResume);
		empResume.setEmpContact(null);

		return empResume;
	}

}