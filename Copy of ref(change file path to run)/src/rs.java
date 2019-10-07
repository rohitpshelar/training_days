import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class rs extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	System.out.println("is r");
	String[] s=request.getParameterValues("rs");
	System.out.println(s);
	for (int i = 1; i <= s.length; i++) {
		System.out.println(s[i]);
	}

	
}
public static void main(String[] args) {
	rs r = new rs();
}

}
