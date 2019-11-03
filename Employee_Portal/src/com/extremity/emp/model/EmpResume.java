package com.extremity.emp.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the emp_resume database table.
 * 
 */
@Entity
@Table(name="emp_resume")
@NamedQuery(name="EmpResume.findAll", query="SELECT e FROM EmpResume e")
public class EmpResume implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="emp_resume_id")
	private int empResumeId;

	private String certification;

	@Column(name="emp_personal_id")
	private int empPersonalId;

	private String experience;

	@Column(name="hsc_percent")
	private float hscPercent;

	@Column(name="pg_percent")
	private float pgPercent;

	private String skill;

	@Column(name="ssc_percent")
	private float sscPercent;

	@Column(name="ug_percennt")
	private float ugPercennt;

	//bi-directional many-to-one association to EmpContact
	@ManyToOne
	@JoinColumn(name="ct_id")
	private EmpContact empContact;

	public EmpResume() {
	}

	public int getEmpResumeId() {
		return this.empResumeId;
	}

	public void setEmpResumeId(int empResumeId) {
		this.empResumeId = empResumeId;
	}

	public String getCertification() {
		return this.certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public int getEmpPersonalId() {
		return this.empPersonalId;
	}

	public void setEmpPersonalId(int empPersonalId) {
		this.empPersonalId = empPersonalId;
	}

	public String getExperience() {
		return this.experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public float getHscPercent() {
		return this.hscPercent;
	}

	public void setHscPercent(float hscPercent) {
		this.hscPercent = hscPercent;
	}

	public float getPgPercent() {
		return this.pgPercent;
	}

	public void setPgPercent(float pgPercent) {
		this.pgPercent = pgPercent;
	}

	public String getSkill() {
		return this.skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public float getSscPercent() {
		return this.sscPercent;
	}

	public void setSscPercent(float sscPercent) {
		this.sscPercent = sscPercent;
	}

	public float getUgPercennt() {
		return this.ugPercennt;
	}

	public void setUgPercennt(float ugPercennt) {
		this.ugPercennt = ugPercennt;
	}

	public EmpContact getEmpContact() {
		return this.empContact;
	}

	public void setEmpContact(EmpContact empContact) {
		this.empContact = empContact;
	}

}