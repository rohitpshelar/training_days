package com.cjc.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cjc.daoImpI.Dao;
import com.cjc.model.RegForm;

public class RegServlet {

	public void regaction(HttpServletRequest request, HttpServletResponse response) {
		

		String fname = request.getParameter("fn");
		String lname = request.getParameter("ln");
		String gender = request.getParameter("sex");
		String qualification = request.getParameter("qual");
		String[] lang = request.getParameterValues("lang");
		String uname = request.getParameter("una");
		String pwd = request.getParameter("pwd");
		String add = request.getParameter("add");
		String photo = request.getParameter("photo");
	
		
System.out.println("PHOTO======"+photo);
		if (lang != null) {
			lang[0] = null;
		}
		String lang2 = "";
		System.out.println("lang2=" + lang2);
		for (String s : lang) {
			System.out.println(s);
			lang2 = s + ", " + lang2;
		}
		System.out.println("final=" + lang2);

		RegForm r = new RegForm();
		r.setFname(fname);
		r.setLname(lname);
		r.setGender(gender);
		r.setQual(qualification);
		r.setLang(lang2);
		r.setAdder(add);
		r.setUname(uname);
		r.setPass(pwd);
		r.setPhoto(photo);

		Dao dao = new Dao();
		int i = dao.AddRegDetails(r);

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
