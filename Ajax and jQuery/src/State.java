
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class State extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		String fn = request.getParameter("fn");
		System.out.println(fn);
		if (fn.equals("MH")) {
			response.getWriter().write("Valid Username");
			
		} else {
			response.getWriter().write("Arre " + fn + " ! yedabhokachya naav dusra taak ('o')");
		}
	}

}
