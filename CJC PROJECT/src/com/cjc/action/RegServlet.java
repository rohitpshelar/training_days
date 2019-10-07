package com.cjc.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cjc.daoImpI.Dao;
import com.cjc.model.RegForm;

import freemarker.template.TemplateException;

public class RegServlet {

	public void regaction(HttpServletRequest request, HttpServletResponse response) {
		//password generator
		RandomString rands = new RandomString();
		String pwd = RandomString.autoGenrator();
		
		String fname = request.getParameter("fn");
		String lname = request.getParameter("ln");
		String email = request.getParameter("email");
	
		
		//email send
		com.cjc.email.EmailSender ess = new com.cjc.email.EmailSender();
		try {
			ess.execute(email,pwd);
		} catch (IOException | TemplateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		RegForm r = new RegForm();
		r.setFname(fname);
		r.setLname(lname);
		r.setEmail(email);
		r.setPass(pwd);
		

		Dao dao = new Dao();
		int i = dao.AddRegDetails1(r);

		System.out.println(i + " Registraion added");

		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
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
