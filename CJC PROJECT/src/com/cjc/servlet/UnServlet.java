package com.cjc.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjc.daoImpI.Dao;
import com.cjc.util.DatabaseServlet;

public class UnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) {

		String Emailcheck = request.getParameter("fn");
		System.out.println("Emailcheck :" + Emailcheck);

		Dao d = new Dao();
		ResultSet rs = d.CheckEmail(Emailcheck);

		try {
			if (rs.next()) {
				System.out.println(rs.getString(1) + " & " + Emailcheck + "=" + rs.getString(1).equals(Emailcheck));
				if (rs.getString(1).equals(Emailcheck)) {
					response.getWriter().write("<h1>Email ! Already Exist </h1>");
					
				}}
					System.out.println("inside else");
					response.getWriter()
							.write("<input type=" + "submit" + " class=" + "button" + " value=" + "Submit" + "> ");
				
				
			
			

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		UnServlet s = new UnServlet();
		Dao d = new Dao();
		DatabaseServlet ds = new DatabaseServlet();
	}
}
