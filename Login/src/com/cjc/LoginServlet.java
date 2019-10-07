package com.cjc;

import java.awt.Event;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

public class LoginServlet extends HttpServlet {

	private static final ServletContext Connection = null;
	private java.sql.Connection con;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		String uname = request.getParameter("un");
		String pwd = request.getParameter("pw");
		RequestDispatcher rd;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("login==Driver loaded");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "root");

			System.out.println(con);
			java.sql.PreparedStatement pst = con
					.prepareStatement("SELECT `uname` FROM `login`.`reg` WHERE uname=? and pw=?");
			pst.setString(1, uname);
			pst.setString(2, pwd);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				/*
				 * Class.forName("com.mysql.jdbc.Driver");
				 * System.out.println("login==Driver loaded"); Connection con2 =
				 * DriverManager
				 * .getConnection("jdbc:mysql://localhost:3306/login", "root",
				 * "root");
				 * 
				 * System.out.println(con2);
				 */
				pst = con.prepareStatement("SELECT * FROM `login`.`reg` LIMIT 0, 30");

				rs = pst.executeQuery();

				ArrayList al = new ArrayList();
				while (rs.next())

				{
					RegForm r = new RegForm();

					al.add(r);
				}

				request.setAttribute("data", al);
				rd = request.getRequestDispatcher("Success.jsp");
				rd.forward(request, response);

				/*
				 * System.out.println("rs2===="+rs2); PrintWriter out =
				 * response.getWriter(); out.write("<html>");
				 * out.write("<body>");
				 * out.write("<h2><div align="+"center"+">Display"); out.write(
				 * "<br><table><tr><td>Firstname   </td><td>     Lastname   </td><td>     Username    </td><td>   Password   </td><td>   Address </td><tr> "
				 * );
				 * 
				 * while(rs2.next()){
				 * out.write("<br><tr><td>"+rs2.getString(1)+"    </td><td>     "
				 * +rs2.getString(2)+"      </td><td>     "+rs2.getString(3)+
				 * "     </td><td>      "
				 * +rs2.getString(4)+"    </td><td>       "
				 * +rs2.getString(5)+"</td><tr>"); }
				 * 
				 * out.write("<br></table><br><br><a href="+"login.jsp"+
				 * "> BACK</a></div></h2>"); out.write("</body>");
				 * out.write("</html>");
				 */

				// rd = request.getRequestDispatcher("Success.jsp");
				// rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("Ilogin.jsp");
				rd.forward(request, response);
			}

		} catch (Exception e) {
			System.out.println("login==in catch");
			e.printStackTrace();

		}

	}

}
