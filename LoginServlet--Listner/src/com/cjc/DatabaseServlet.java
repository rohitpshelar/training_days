package com.cjc;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DatabaseServlet implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent contextEvent) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("login==Driver loaded");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "root");
			System.out.println("login==Connection extablish");
			
			ServletContext s=contextEvent.getServletContext();
			s.setAttribute("data", con);
		
			
			
		
	}catch (Exception e) {
		// TODO: handle exception
	}

	
}
}
