package com.extremity.emp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the emp_perks_salary database table.
 * 
 */
@Entity
@Table(name="emp_perks_salary")
@NamedQuery(name="EmpPerksSalary.findAll", query="SELECT e FROM EmpPerksSalary e")
public class EmpPerksSalary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="emp_sal_id")
	private int empSalId;

	@Column(name="basic_sal")
	private String basicSal;

	private String bonus;

	private String gross;

	@Column(name="house_all")
	private String houseAll;

	@Column(name="medicle_all")
	private String medicleAll;

	@Column(name="travlling_all")
	private String travllingAll;

	//bi-directional many-to-one association to EmpPayslip
	@OneToMany(mappedBy="empPerksSalary")
	private List<EmpPayslip> empPayslips;

	public EmpPerksSalary() {
	}

	public int getEmpSalId() {
		return this.empSalId;
	}

	public void setEmpSalId(int empSalId) {
		this.empSalId = empSalId;
	}

	public String getBasicSal() {
		return this.basicSal;
	}

	public void setBasicSal(String basicSal) {
		this.basicSal = basicSal;
	}

	public String getBonus() {
		return this.bonus;
	}

	public void setBonus(String bonus) {
		this.bonus = bonus;
	}

	public String getGross() {
		return this.gross;
	}

	public void setGross(String gross) {
		this.gross = gross;
	}

	public String getHouseAll() {
		return this.houseAll;
	}

	public void setHouseAll(String houseAll) {
		this.houseAll = houseAll;
	}

	public String getMedicleAll() {
		return this.medicleAll;
	}

	public void setMedicleAll(String medicleAll) {
		this.medicleAll = medicleAll;
	}

	public String getTravllingAll() {
		return this.travllingAll;
	}

	public void setTravllingAll(String travllingAll) {
		this.travllingAll = travllingAll;
	}

	public List<EmpPayslip> getEmpPayslips() {
		return this.empPayslips;
	}

	public void setEmpPayslips(List<EmpPayslip> empPayslips) {
		this.empPayslips = empPayslips;
	}

	public EmpPayslip addEmpPayslip(EmpPayslip empPayslip) {
		getEmpPayslips().add(empPayslip);
		empPayslip.setEmpPerksSalary(this);

		return empPayslip;
	}

	public EmpPayslip removeEmpPayslip(EmpPayslip empPayslip) {
		getEmpPayslips().remove(empPayslip);
		empPayslip.setEmpPerksSalary(null);

		return empPayslip;
	}

}