package com.cjc.action;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjc.daoImpI.Dao;
import com.cjc.model.RegForm;

public class UpdatedReg extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void updatedAction(HttpServletRequest request, HttpServletResponse response) {
	
		String id = request.getParameter("r");
		String fname = request.getParameter("fn");
		String lname = request.getParameter("ln");
		String gender = request.getParameter("gen");
		String email = request.getParameter("email");
		String qualification = request.getParameter("qual");
		String[] lang = request.getParameterValues("lang");
		String add = request.getParameter("add");
		String uname = request.getParameter("un");
		String pwd = request.getParameter("pw");
	

		String lang2 = "";
		System.out.println("lang2=" + lang2);
		for (String s : lang) {
			System.out.println(s);
			lang2 = s + ", " + lang2;
		}
		System.out.println("final=" + lang2);

		RequestDispatcher rd;
		
		RegForm	 r = new RegForm();
		r.setRegid(Integer.parseInt(id));
		r.setFname(fname);
		r.setLname(lname);
		r.setGender(gender);
		r.setEmail(email);
		r.setQual(qualification);
		r.setLang(lang2);
		r.setAdder(add);
		r.setUname(uname);
		r.setPass(pwd);
	
		Dao d = new Dao();
		int i=d.UpdateRegDetails(r);
		System.out.println(i+" Recort Updated");
		
			ArrayList<?> al = d.GetLoginDetails();
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
