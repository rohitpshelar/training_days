package com.cjc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjc.daoImpI.Dao;


public class TempR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	System.out.println(request.getParameter("firstname"));
	System.out.println(request.getParameter("middle"));
	System.out.println(request.getParameter("lastname"));
	System.out.println(request.getParameter("phone"));
	System.out.println(request.getParameter("email"));
	System.out.println(request.getParameter("username"));
	System.out.println(request.getParameter("password"));
	System.out.println(request.getParameter("password2"));
	
	
	
	
	
	
	
	
	
	
	System.out.println("IN DISE TEMPR");
	Dao d=new Dao();
	ArrayList<?> al = d.GetLoginDetailsSpecific("r", "r");
	request.setAttribute("data", al);
	RequestDispatcher rdDispatcher =request.getRequestDispatcher("temp.jsp");
	rdDispatcher.forward(request, response);
}

}
