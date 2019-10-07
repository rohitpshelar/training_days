package com.cjc.emailRegistration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.cjc.dao.UserDAO;
import com.cjc.db.DBException;
import com.cjc.model.StatusPojo;
import com.cjc.model.UserPojo;
import com.cjc.util.BCrypt;
import com.cjc.util.GlobalConstants;
import com.cjc.util.MailUtil;
import com.cjc.util.Utils;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(ForgotPassword.class.getName());
	
    public ForgotPassword() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputEmail = request.getParameter("inputEmail");
		StatusPojo sp = new StatusPojo(); 
		try {
			UserPojo up = UserDAO.selectUSERbyEmail(inputEmail); 
			if(up!=null) {
				String hash = Utils.prepareRandomString(30);
				UserDAO.updateEmailVerificationHashForResetPassword(inputEmail, BCrypt.hashpw(hash,GlobalConstants.SALT));
				MailUtil.sendResetPasswordLink(up.getUSER_ID()+"", inputEmail, hash);
				sp.setCode(0);
				sp.setMessage("We have sent reset password link to your email");
			} else {
				sp.setCode(-1);
				sp.setMessage("This email doesn't exist");
			}
		} catch (DBException | MessagingException e) {
			LOGGER.debug(e.getMessage());
			sp.setCode(-1);
			sp.setMessage(e.getMessage());
		}
		PrintWriter pw = response.getWriter();
	    pw.write(Utils.toJson(sp));
	    pw.flush();
	    pw.close();
	}

}
