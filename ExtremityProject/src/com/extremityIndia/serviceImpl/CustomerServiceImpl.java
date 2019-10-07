package com.extremityIndia.serviceImpl;

import java.util.List;

import com.extremityIndia.dao.CustomerDao;
import com.extremityIndia.daoImpl.CustomerDaoImpl;
import com.extremityIndia.hibernate.Customer;
import com.extremityIndia.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{

	public List<Customer> getallCustomer() {
		CustomerDao customerDao=new CustomerDaoImpl();
		
		return  customerDao.getCustomerList();
		
	}

}
