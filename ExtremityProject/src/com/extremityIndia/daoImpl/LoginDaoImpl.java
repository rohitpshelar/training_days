package com.extremityIndia.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.extremityIndia.context.CallContextService;
import com.extremityIndia.dao.LoginDao;
import com.extremityIndia.hibernate.Systemlogin;

public class LoginDaoImpl implements LoginDao{

	public List<Systemlogin> loginCheck(Systemlogin systemlogin) {
		// TODO Auto-generated method stub
		
		
		  System.out.println("dao=="+systemlogin.getUname());
		  System.out.println("dao==="+systemlogin.getPassword());
		  
		  
		  Session hibernateSession = (Session)(CallContextService.getInstance().getContext().getAttribute("hibernateSession"));
		  
		   Criteria cr= hibernateSession.createCriteria(Systemlogin.class);
		   
		      cr.add(Restrictions.eq("uname", systemlogin.getUname())).add(Restrictions.eq("password", systemlogin.getPassword()));
		      
		      List<Systemlogin> list=  cr.list();
		      
		      
		      
		      
		      
		      
		      
		  
		  
		  
		
		return list;
	}

}
