package com.cjc.action;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjc.daoImpI.Dao;


public class UpdateReg extends HttpServlet {

public void updateAction(HttpServletRequest request, HttpServletResponse response) {
	

		String id = request.getParameter("radio");
		System.out.println("id="+id);
		RequestDispatcher rd;
		Dao d = new Dao();
		ArrayList al = d.GetLoginDetails(Integer.parseInt(id));
		request.setAttribute("data", al);
		rd = request.getRequestDispatcher("update.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
