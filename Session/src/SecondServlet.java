import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SecondServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("service");
		
		HttpSession session= request.getSession();
		
		if (!session.isNew()) {
			session.invalidate();
			request.getSession();
			
		}
		if(session==null){
			RequestDispatcher rd=request.getRequestDispatcher("first.jsp");
			rd.forward(request, response);
			System.out.println("null2");
		}
		RequestDispatcher rd=request.getRequestDispatcher("thied.jsp");
		request.getParameter("n1");
		rd.forward(request, response);
		System.out.println("end");
		
	}
}
