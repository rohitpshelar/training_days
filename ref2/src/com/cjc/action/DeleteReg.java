package com.cjc.action;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjc.daoImpI.Dao;

public class DeleteReg {

	public void delReg(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("radio");
		System.out.println("Id="+id);

		RequestDispatcher rd;
		Dao d = new Dao();
		d.DeleteReg(Integer.parseInt(id));

		ArrayList al = d.GetLoginDetails();

		request.setAttribute("data", al);
		rd = request.getRequestDispatcher("Success.jsp");
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
