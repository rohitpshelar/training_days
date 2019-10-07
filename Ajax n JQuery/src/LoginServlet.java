import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		System.out.println("in service");
		String fn = request.getParameter("fn");
		System.out.println(fn);
		if (fn.equals("admin")) {
			//response.getWriter().write("Valid Username servicesss");
			response.getWriter().write("<input type="+"submit"+" value="+"Submit"+">");

		} else {
			//response.getWriter().write("<input type="+"submit"+" value="+"Submit"+">");
			response.getWriter().write("Invalid Usernamess ('o')");
		}
	}
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
	response.getWriter().write("Success");
}
protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
	response.getWriter().write("Success");
}
	public static void main(String[] args) {
		LoginServlet l = new LoginServlet();
	}
}
