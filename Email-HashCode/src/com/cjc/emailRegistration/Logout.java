package com.cjc.emailRegistration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjc.dao.UserDAO;
import com.cjc.db.DBException;
import com.cjc.model.StatusPojo;
import com.cjc.model.UserPojo;
import com.cjc.util.BCrypt;
import com.cjc.util.GlobalConstants;
import com.cjc.util.Utils;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute(GlobalConstants.USER, null);
		response.sendRedirect("/demos/index.jsp");
	}

}
