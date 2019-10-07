package com.hibernate;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		/*Configuration configuration = new Configuration();
		configuration = configuration.configure();
		SessionFactory sessionf = configuration.buildSessionFactory();
		Session session = sessionf.openSession();*/
		
		Session session = HibernateSessionFactory.getSession();
	
		Reg rohit = new Reg();
		rohit.setFname("rohit");
		rohit.setLname("shelar");
		rohit.setGender("male");
		rohit.setQual("mca");
		rohit.setAdds("pune");
		rohit.setLang("marathi");
		rohit.setUname("g");
		rohit.setPw("g");
		rohit.setPhoto(null);
		
		//rohit.setPhoto("C:/Users/ROHIT SHELAR/Myeclipse/Login With folder N templet=photo/WebRoot/DBimages/cc.jpg");
		
		session.save(rohit);
		Transaction tx = session.beginTransaction();
		tx.commit();
		
		RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
		rd.forward(request, response);
	}

}
