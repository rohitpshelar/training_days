import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Student;


public class LoginServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Set value in class Student
	Student s = new Student();
	s.setRollno(1);
	s.setName("rohit");
	request.setAttribute("data", s);
	
	
	RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
	rd.forward(request, response);
	}

}
