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

		String uncheck = request.getParameter("fn");
		System.out.println("uncheck" + uncheck);

		Dao d = new Dao();
		ResultSet rs = d.GetLoginUsername();
		
		try {
			if (rs.next()) {
				System.out.println(rs.getString(1)+" & "+uncheck+"="+rs.getString(1).equals(uncheck));
					if(rs.getString(1).equals(uncheck)){
				response.getWriter().write("User Name ! Already Exist ");
				response.getWriter().write("<input type=" + "submit" + " class=" + "button" + " value=" + "Submit" + "> ");
				
					} 	response.getWriter().write("<input type=" + "submit" + " class=" + "button" + " value=" + "Submit" + "> ");
					}else {

				response.getWriter().write("<input type=" + "submit" + " class=" + "button" + " value=" + "Submit" + "> ");
					}
				
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
