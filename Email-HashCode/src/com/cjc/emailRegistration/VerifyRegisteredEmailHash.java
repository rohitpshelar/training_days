package com.cjc.emailRegistration;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.cjc.dao.UserDAO;
import com.cjc.db.DBException;
import com.cjc.model.UserPojo;
import com.cjc.util.BCrypt;
import com.cjc.util.GlobalConstants;
import com.cjc.util.MailUtil;
import com.cjc.util.Utils;

/**
 * Servlet implementation class VerifyRegisteredEmailHash
 */
@WebServlet("/VerifyRegisteredEmailHash")
public class VerifyRegisteredEmailHash extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(VerifyRegisteredEmailHash.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyRegisteredEmailHash() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get user Id and email verification code Hash code  
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		String hash = BCrypt.hashpw(request.getParameter("hash"), GlobalConstants.SALT);
		String scope = request.getParameter("scope");
		String message = null;
		try {
			// verify with database
			if(UserDAO.verifyEmailHash(userId.toString(), hash) && scope.equals(GlobalConstants.ACTIVATION)) {
			   //update status as active
			   UserDAO.updateStaus(userId.toString(), "active");
			   message = "  <p >Email verified successfully. Account was activated. ClicK <a href=\"index.jsp\">here</a> to login</p>";
			} else if(UserDAO.verifyEmailHash(userId.toString(), hash) && scope.equals(GlobalConstants.RESET_PASSWORD)) {
			   //update status as active
			   UserDAO.updateStaus(userId.toString(), "active");
			   //put some session for user
			   request.getSession().setAttribute(GlobalConstants.USER, userId);
			   request.getSession().setAttribute(GlobalConstants.IS_RESET_PASSWORD_VERIFIED, GlobalConstants.YES);
			   request.getRequestDispatcher("/WEB-INF/resetPassword.jsp").forward(request, response);	
			} else {
			   //now increment verification attempts 
			   int attempts = UserDAO.incrementVerificationAttempts(userId.toString());
			   if(attempts == 20) {
				   // reset verification code if attempts equal to 20 
				   String hashcode = Utils.prepareRandomString(30);
				   UserDAO.updateEmailVerificationHash(userId.toString(), BCrypt.hashpw(hashcode, GlobalConstants.SALT));
				   UserPojo up = UserDAO.selectUSER(userId.toString());
				   MailUtil.sendEmailRegistrationLink(userId.toString(), up.getEMAIL(), hashcode);
				   message = "20 times Wrong Email Validation Input Given. So we are sent new activation link to your Email";
			   } else {
				   message = "Wrong Email Validation Input";   
			   }
			}
		} catch (DBException e) {
			LOGGER.debug(e.getMessage());
			message = e.getMessage();
		} catch (AddressException e) {
			message = e.getMessage();
			LOGGER.debug(e.getMessage());
		} catch (MessagingException e) {
			message = e.getMessage();
			LOGGER.debug(e.getMessage());
		}
		if(message!=null) {
			request.setAttribute(GlobalConstants.MESSAGE, message);
			request.getRequestDispatcher("/messageToUser.jsp").forward(request, response);	
		} 
	}

}
