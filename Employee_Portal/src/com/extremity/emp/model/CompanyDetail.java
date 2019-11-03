package com.extremity.emp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the company_details database table.
 * 
 */
@Entity
@Table(name="company_details")
@NamedQuery(name="CompanyDetail.findAll", query="SELECT c FROM CompanyDetail c")
public class CompanyDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="c_id")
	private int cId;

	@Column(name="c_location")
	private String cLocation;

	@Column(name="c_name")
	private String cName;

	//bi-directional many-to-one association to EmpPersonalDetail
	@OneToMany(mappedBy="companyDetail")
	private List<EmpPersonalDetail> empPersonalDetails;

	public CompanyDetail() {
	}

	public int getCId() {
		return this.cId;
	}

	public void setCId(int cId) {
		this.cId = cId;
	}

	public String getCLocation() {
		return this.cLocation;
	}

	public void setCLocation(String cLocation) {
		this.cLocation = cLocation;
	}

	public String getCName() {
		return this.cName;
	}

	public void setCName(String cName) {
		this.cName = cName;
	}

	public List<EmpPersonalDetail> getEmpPersonalDetails() {
		return this.empPersonalDetails;
	}

	public void setEmpPersonalDetails(List<EmpPersonalDetail> empPersonalDetails) {
		this.empPersonalDetails = empPersonalDetails;
	}

	public EmpPersonalDetail addEmpPersonalDetail(EmpPersonalDetail empPersonalDetail) {
		getEmpPersonalDetails().add(empPersonalDetail);
		empPersonalDetail.setCompanyDetail(this);

		return empPersonalDetail;
	}

	public EmpPersonalDetail removeEmpPersonalDetail(EmpPersonalDetail empPersonalDetail) {
		getEmpPersonalDetails().remove(empPersonalDetail);
		empPersonalDetail.setCompanyDetail(null);

		return empPersonalDetail;
	}

}