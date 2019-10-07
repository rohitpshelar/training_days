import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		response.getWriter().write("Success");
	}
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
	response.getWriter().write("Success");
}
protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
	response.getWriter().write("Success");
}
	public static void main(String[] args) {
		LoginsServlet l = new LoginsServlet();
	}
}
