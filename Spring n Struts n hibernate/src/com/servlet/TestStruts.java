package com.servlet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.HibernateSessionFactory;
import com.hibernate.Reg;
import com.opensymphony.xwork2.ActionSupport;

public class TestStruts extends ActionSupport {
	
	Reg rohit;
	private String  uname;
	private String  password;
	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Reg getRohit() {
		return rohit;
	}

	public void setRohit(Reg rohit) {
		this.rohit = rohit;
	}

	public String login() {
		
		Session session = HibernateSessionFactory.getSession();
		
		Reg rohit = new Reg();
		rohit.setFname("rohit");
		rohit.setLname("shelar");
		rohit.setGender("male");
		rohit.setQual("mca");
		rohit.setAdds("pune");
		rohit.setLang("marathi");
		rohit.setUname("g");
		rohit.setPw("g");
		rohit.setPhoto(null);
		
		//rohit.setPhoto("C:/Users/ROHIT SHELAR/Myeclipse/Login With folder N templet=photo/WebRoot/DBimages/cc.jpg");
		
		session.save(rohit);
		Transaction tx = session.beginTransaction();
		tx.commit();
		
		
		
		
		return "success";
	}
	

}
