import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String s=request.getParameter("un");
System.out.println(s);

	if (s.equals("rohit")) {
		Writer writer=response.getWriter();
		writer.write("welcome");
		
		
		
	} else {
		Writer writer=response.getWriter();
		writer.write("Invalid user");
	}
	}

	
}
