package com.extremity.emp.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the repository database table.
 * 
 */
@Entity
@NamedQuery(name="Repository.findAll", query="SELECT r FROM Repository r")
public class Repository implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="repo_id")
	private int repoId;

	@Column(name="emp_indentity_card")
	private String empIndentityCard;

	@Column(name="emp_offer_letter")
	private String empOfferLetter;

	@Column(name="emp_photo")
	private String empPhoto;

	@Column(name="emp_resume_id")
	private String empResumeId;

	public Repository() {
	}

	public int getRepoId() {
		return this.repoId;
	}

	public void setRepoId(int repoId) {
		this.repoId = repoId;
	}

	public String getEmpIndentityCard() {
		return this.empIndentityCard;
	}

	public void setEmpIndentityCard(String empIndentityCard) {
		this.empIndentityCard = empIndentityCard;
	}

	public String getEmpOfferLetter() {
		return this.empOfferLetter;
	}

	public void setEmpOfferLetter(String empOfferLetter) {
		this.empOfferLetter = empOfferLetter;
	}

	public String getEmpPhoto() {
		return this.empPhoto;
	}

	public void setEmpPhoto(String empPhoto) {
		this.empPhoto = empPhoto;
	}

	public String getEmpResumeId() {
		return this.empResumeId;
	}

	public void setEmpResumeId(String empResumeId) {
		this.empResumeId = empResumeId;
	}

}