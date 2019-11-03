package com.extremity.emp.model;

// default package
// Generated Mar 29, 2016 2:52:28 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "customer", catalog = "krishiseva")
public class Customer implements java.io.Serializable {

	private Integer custid;
	private Systemlogin systemlogin;
	private String custname;
	private String address;
	private long phone;
	private String email;
	private Date createddate;

	public Customer() {
	}

	public Customer(String custname, String address, long phone, String email,
			Date createddate) {
		this.custname = custname;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.createddate = createddate;
	}

	public Customer(Systemlogin systemlogin, String custname, String address,
			long phone, String email, Date createddate) {
		this.systemlogin = systemlogin;
		this.custname = custname;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.createddate = createddate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "custid", unique = true, nullable = false)
	public Integer getCustid() {
		return this.custid;
	}

	public void setCustid(Integer custid) {
		this.custid = custid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uId")
	public Systemlogin getSystemlogin() {
		return this.systemlogin;
	}

	public void setSystemlogin(Systemlogin systemlogin) {
		this.systemlogin = systemlogin;
	}

	@Column(name = "custname", nullable = false, length = 45)
	public String getCustname() {
		return this.custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	@Column(name = "address", nullable = false, length = 45)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "Phone", nullable = false)
	public long getPhone() {
		return this.phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Column(name = "email", nullable = false, length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "createddate", nullable = false, length = 10)
	public Date getCreateddate() {
		return this.createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

}
