package com.cjc.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjc.daoImpI.Dao;



public class LoginServlet {

	
	
	
public void LoginAction(HttpServletRequest request, HttpServletResponse response) {


		String uname = request.getParameter("un");
	
		String pwd = request.getParameter("pw");
		System.out.println("Uname ="+uname+" Pass ="+ pwd);
		RequestDispatcher rd;
		Dao d = new Dao();
		
		
		if(uname.equals("admin") && pwd.equals("admin"))
		{
			System.out.println("inside admin");
		ArrayList<?> al = d.GetLoginDetails();
		request.setAttribute("data", al);
		rd = request.getRequestDispatcher("Success.jsp");
		
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}else {
			
		
		
		ResultSet rs = d.GetLoginDetails(uname, pwd);
		
		try {
			
			if (rs.next()) {
				
				System.out.println("in rs.next");
				if (uname.equals(rs.getString(1)) && pwd.equals(rs.getString(2))) {
					System.out.println("inside if");
					ArrayList<?> al = d.GetLoginDetailsSpecific(uname, pwd);
					request.setAttribute("data", al);
					rd = request.getRequestDispatcher("temp.jsp");
					rd.forward(request, response);
				}
				
				
			 else {
				request.setAttribute("msg", "*Username or Password Invalid*                     ('_')");
				rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}}

}
