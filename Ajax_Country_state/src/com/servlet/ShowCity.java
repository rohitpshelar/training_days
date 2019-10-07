package com.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DaoIMPL.DaoIMPL;


public class ShowCity extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int cityId=Integer.parseInt(request.getParameter("cityId")); 

		System.out.println("from service method "+cityId);
		 String buffer="<select name='city' ><option value='-1'>Select</option>";  
		 try{
			 DaoIMPL d=new DaoIMPL();
				ResultSet rs = d.getCity(cityId);
			   while(rs.next()){
			   buffer=buffer+"<option value='"+rs.getString(1)+"'>"+rs.getString(2)+"</option>";  
			   }  
			 buffer=buffer+"</select>";  
			 response.getWriter().println(buffer); 
			 }
			 catch(Exception e){
			     System.out.println(e);
			 }

		
		
	}


}
