
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class s extends HttpServlet {
	private static final long serialVersionUID = 1L;
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("doGET");
	String f = request.getParameter("t2");
	HttpSession session = request.getSession(false);
	System.out.println(session);
	if(session==null){
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);				
	}else {	
	session.setAttribute("t2", f);
	RequestDispatcher rd = request.getRequestDispatcher("t.jsp");
	rd.forward(request, response);
	}
	
//	HttpSession Session=request.getSession(false);  
    /*if(session!=null ){  
     
    RequestDispatcher rd = request.getRequestDispatcher("t.jsp");
	rd.forward(request, response);
    
    }  
    else{  
        //out.print("Please login first");  
        request.getRequestDispatcher("index.jsp").include(request, response);  
    }*/  
	

	
	
	
}
	/*@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		System.out.println("SERVICE");
		String f = request.getParameter("t2");
		HttpSession session = request.getSession(false);
		System.out.println(session);
		if(session==null){
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);				
		}else {	
		session.setAttribute("t2", f);
		RequestDispatcher rd = request.getRequestDispatcher("t.jsp");
		rd.forward(request, response);
		}
	}*/
}
