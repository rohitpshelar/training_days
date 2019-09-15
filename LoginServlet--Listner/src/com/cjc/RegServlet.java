package com.cjc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fname=request.getParameter("fn");
		String lname=request.getParameter("ln");
		String uname=request.getParameter("una");
		String pwd=request.getParameter("pwd");
		String add=request.getParameter("add");
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("reg===Driver loaded");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root","root");
		System.out.println("reg===Connection extablish");
			Statement st=con.createStatement();
			String sql="INSERT INTO `login`.`reg` (`fname`, `lname`, `uname`, `pw`, `add`) VALUES ('"+fname+"', '"+lname+"', '"+uname+"', '"+pwd+"', '"+add+"');";
			st.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("reg===in catch");
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
}
