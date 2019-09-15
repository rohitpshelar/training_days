package servlet.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.mail.handlers.text_plain;

public class Test extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("init");
	}

	@Override
	public void service(HttpServletRequest re, HttpServletResponse rsp) {
		System.out.println("service method===start");

		String name = re.getParameter("un");
		String pass = re.getParameter("pw");

		if (name.equals("rohit") && pass.equals("rohit")) {
			try {
				System.out.println("In IF===");
				System.out.println(name.equals("rohit") && pass.equals("rohit"));
				PrintWriter out = rsp.getWriter();
				out.write("<html>");
				out.write("<body>");
				out.write("<br><br><br><h2><div align="+"center"+">Welcome <p style="+"text-transform: capitalize; color: red;"+">"+name+"</p>");
				out.write("<br><br><br><a href="+"index.html"+"> BACK</a></div>");
				out.write("</body>");
				out.write("</html>");
			} catch (IOException e) {
				System.out.println("catch");
				e.printStackTrace();
			}
		} else {
			System.out.println("In ELSE===");
			System.out.println(name.equals("rohit") && pass.equals("rohit"));
			try {
				PrintWriter out = rsp.getWriter();
				out.write("<html>");
				out.write("<body>");
				out.write("<br><br><br><h2><div align="+"center"+">Invalid user");
				out.write("<br><br><br><a href="+"index.html"+"> BACK</a></div>");
				out.write("</body>");
				out.write("</html>");
			} catch (IOException e) {
				System.out.println("catch");
				e.printStackTrace();
			}
		}
		System.out.println("Username:" + name);
		System.out.println("Password:" + pass);
		System.out.println("service method===end");
	}

	@Override
	public void destroy() {
		System.out.println("distroy");
	}

}
