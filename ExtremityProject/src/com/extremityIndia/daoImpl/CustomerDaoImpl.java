package com.extremityIndia.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.extremityIndia.context.CallContextService;
import com.extremityIndia.dao.CustomerDao;
import com.extremityIndia.hibernate.Customer;

public class CustomerDaoImpl implements CustomerDao {

	public List<Customer> getCustomerList() {
		Session hibernateSession = (Session)(CallContextService.getInstance().getContext().getAttribute("hibernateSession"));
		
		Criteria cr=hibernateSession.createCriteria(Customer.class);
		
		  List<Customer> list=  cr.list();
		
		
		 /* for (Customer customer : list) {
			  System.out.println(customer.getCname());
			  System.out.println(customer.getAddr());
			
		}*/
		  
		
		return list;
	}

}
