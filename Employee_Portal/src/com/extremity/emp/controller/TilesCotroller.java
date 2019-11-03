package com.extremity.emp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TilesCotroller {

    @RequestMapping(value="/")
	public String getIndex()
	{   
    	System.out.println("index");
		return "login";
	}

       
    @RequestMapping(value="/login.action")
    public String getLogin(){
    	System.out.println("Login");
    	
    	return "login";
    }
    
    
  
   
}
