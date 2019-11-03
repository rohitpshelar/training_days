package com.extremity.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.extremity.emp.model.MyData;
import com.extremity.emp.service.IAdminService;




@Controller

public class AdminController {

	@Autowired
	IAdminService iAdminService;
	
	@RequestMapping(value="/login1.action")
    public String login(){
		
    	System.out.println("okkkk");
   return "admin_header";
    	
    }
	
	
	@RequestMapping("purchaseDetails.action")
	public ModelAndView  getPurchaseDetails(){
		
		
		
		ModelAndView purchaseDetails=new ModelAndView("purchaseDetails");
		return purchaseDetails;
		
	}
	
	@RequestMapping("Employee_Details.action")
	public ModelAndView  getEmployeeDetails(){
		
		ModelAndView Employee_Details=new ModelAndView("Employee_Details");
		return Employee_Details;
		
	}
	
	@RequestMapping("adddata.action")
	public String addValue(@ModelAttribute MyData myData){
		
		iAdminService.addValue(myData);
		
		System.out.println("ok");
		return null;
	}
	
}
