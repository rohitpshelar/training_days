
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class t extends HttpServlet {
	private static final long serialVersionUID = 1L;
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String f = request.getParameter("t3");
	HttpSession session = request.getSession(false);
	System.out.println(session);
	if(session==null){
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);				
	}else {		
	session.setAttribute("t3", f);
	RequestDispatcher rd = request.getRequestDispatcher("d.jsp");
	rd.forward(request, response);
	}
}
	/*@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		String f = request.getParameter("t3");
		HttpSession session = request.getSession(false);
		System.out.println(session);
		if(session==null){
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);				
		}else {		
		session.setAttribute("t3", f);
		RequestDispatcher rd = request.getRequestDispatcher("d.jsp");
		rd.forward(request, response);
		}
	}*/
}
