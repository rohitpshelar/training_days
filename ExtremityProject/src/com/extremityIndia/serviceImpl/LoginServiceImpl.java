package com.extremityIndia.serviceImpl;

import java.util.List;

import com.extremityIndia.dao.LoginDao;
import com.extremityIndia.daoImpl.LoginDaoImpl;
import com.extremityIndia.hibernate.Systemlogin;
import com.extremityIndia.service.LoginService;

public class LoginServiceImpl implements LoginService{

	LoginDao loginDao;
	
	public String getloginCheck(Systemlogin systemlogin) {
		// TODO Auto-generated method stub
		
		System.out.println("service===="+systemlogin.getUname());
		System.out.println("Service==="+systemlogin.getPassword());
		
		//LoginDao loginDao=new LoginDaoImpl();
		
	List<Systemlogin> list=	loginDao.loginCheck(systemlogin);
	
	if(list.isEmpty())
		return "error";
	
	
	  Systemlogin login=  list.get(0);
	  
	  
		if(login.getUtype().equals("admin"))
			return "admin";
		 
		if(login.getUtype().equals("customer"))
			return "customer";
		
		if(login.getUtype().equals("employee"))
			return "employee";
		
		return "error";
	}

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

}
