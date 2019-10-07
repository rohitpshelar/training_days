
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class f
 */
@WebServlet("/f")
public class f extends HttpServlet {
	//static String r; 
	private static final long serialVersionUID = 1L;
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("doGet");
	String f = request.getParameter("t1");

	HttpSession session = request.getSession();
	System.out.println(session);
	if(!session.isNew()){
		session.invalidate();
		session = request.getSession();
	}
	else
	{
		System.out.println(session);
	session.setAttribute("t1", f);
	RequestDispatcher rd = request.getRequestDispatcher("s.jsp");
	rd.forward(request, response);
	}
}

	/*@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		System.out.println("SERVICE");
		String f = request.getParameter("t1");

		HttpSession session = request.getSession();
		System.out.println(session);
		if(!session.isNew()){
			session.invalidate();
			session = request.getSession();
		}
		else
		{
			System.out.println(session);
		session.setAttribute("t1", f);
		RequestDispatcher rd = request.getRequestDispatcher("s.jsp");
		rd.forward(request, response);
		}
	}*/
}
