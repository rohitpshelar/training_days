package com.extremityIndia.action;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.extremityIndia.context.CallContextService;

import com.extremityIndia.hibernate.City;
import com.extremityIndia.hibernate.Customer;
import com.extremityIndia.hibernate.State;

import com.extremityIndia.service.CustomerService;
import com.extremityIndia.serviceImpl.CustomerServiceImpl;

public class CustomerAction {
	
	
	

	private Map<String, String> stateMap = new LinkedHashMap<String, String>();
	private Map<Integer, String> cityMap = new LinkedHashMap<Integer, String>();
	private String dummyMsg;
	//Parameter for Jquery
	private String countryName;
	private String stateName;
	
	List<State> statelist;
	
	
	
	public String loadState()
	{
		
		Session hibernateSession = (Session)(CallContextService.getInstance().getContext().getAttribute("hibernateSession"));
		
		
		statelist=   hibernateSession.createCriteria(State.class).list();
		
		System.out.println(statelist.size());
		return "success";
		
	}
	
	
	

	public String fetchState() {
		System.out.println("get State");
		if (countryName.equals("India")) {
			stateMap.put("0", "Select State");
			stateMap.put("1", "Kerala");
			stateMap.put("2", "Tamil Nadu");
			stateMap.put("3", "Jammu Kashmir");
			stateMap.put("4", "Assam");
		} else if (countryName.equals("US")) {
			stateMap.put("0", "Select State");
			stateMap.put("1", "Georgia");
			stateMap.put("2", "Utah");
			stateMap.put("3", "Texas");
			stateMap.put("4", "New Jersey");
		} else if (countryName.equals("Select Country")) {
			stateMap.put("1", "Select State");
		}
		dummyMsg = "State Fetched";
		return "success";
	}

	public String selectCity() {
		System.out.println("Fetch City222222");
		System.out.println(stateName+"**********");
		
		
		Session hibernateSession = (Session)(CallContextService.getInstance().getContext().getAttribute("hibernateSession"));
		
		int x=Integer.parseInt(stateName);
	State state=(State)	  hibernateSession.load(State.class, x);
		
	
	
	   Set<City> citiset=state.getCities();
	   
	   
	   
	      for (City city : citiset) {
	    	  
	    	 cityMap.put(city.getCityid(), city.getCityname());
			
		}
	   
	   
	   
	   
	   
	   
	
		/*if (stateName.equals("1")) {
			cityMap.put("1", "AAA");
			cityMap.put("2", "BBB");
			cityMap.put("3", "CCC");
			cityMap.put("4", "DDD");
		} else if (stateName.equals("2")) {
			cityMap.put("1", "Tamil Nadu1");
			cityMap.put("2", "Tamil Nadu2");
			cityMap.put("3", "Tamil Nadu3");
			cityMap.put("4", "Tamil Nadu4");
		} else if (countryName.equals("Select State")) {
			cityMap.put("1", "Select City");
		}*/
		dummyMsg = "City Fetched";
		return "success";
	}
	/*
	public String getCity123444() {
		System.out.println("Fetch");
		dummyMsg = "City Fetched";
		return "success";
	}

	public String getCity123666666() {
		System.out.println("Fetch City22222288888888888888");
		dummyMsg = "City Fetched";
		return "success";
	}*/
	public Map<String, String> getStateMap() {
		return stateMap;
	}

	public String getDummyMsg() {
		return dummyMsg;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setStateMap(Map<String, String> stateMap) {
		this.stateMap = stateMap;
	}

	public void setDummyMsg(String dummyMsg) {
		this.dummyMsg = dummyMsg;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Map<Integer, String> getCityMap() {
		return cityMap;
	}

	public void setCityMap(Map<Integer, String> cityMap) {
		this.cityMap = cityMap;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	
	
	
	
	List<Customer> list;
	
	
	public String fetchCustomerList()
	{
		
		
		CustomerService customerService=new CustomerServiceImpl();
		
		
		list=     customerService.getallCustomer();
		
		
		
		
		return "success";
		
		
	}

	public List<Customer> getList() {
		return list;
	}

	public void setList(List<Customer> list) {
		this.list = list;
	}




	public List<State> getStatelist() {
		return statelist;
	}




	public void setStatelist(List<State> statelist) {
		this.statelist = statelist;
	}

	

}
