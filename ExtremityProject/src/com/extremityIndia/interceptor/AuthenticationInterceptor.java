package com.extremityIndia.interceptor;



import com.extremityIndia.model.Login;

import java.util.Date;
import java.util.Map;

/*import org.apache.log4j.Logger;*/

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ValidationAware;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * @author Kunal Sonu
 *
 */
public class AuthenticationInterceptor implements Interceptor {

	private static final long serialVersionUID = 108L;

	//protected Logger logger = Logger.getLogger(this.getClass().getName());

	public void destroy() {

	}

	public void init() {

	}

	public String intercept(ActionInvocation actionInvocation) throws Exception {

		System.out.println("AuthenticationInterceptor :intercept(ActionInvocation) ");
		String user = null;
		
		System.out.println("Action Name :"	+ actionInvocation.getInvocationContext().getName());
		
		long stTime = new Date().getTime();
		
		Map<String,Object> session = actionInvocation.getInvocationContext().getSession();

		

		if (session != null && !session.isEmpty()) {
		/*	user = (Login) session.get("uname");*/
			user = (String)session.get("uname");
			System.out.println("user from session >>> " + user);
			
		} else {
			ValidationAware action = (ValidationAware) actionInvocation
					.getAction();
			action.getActionErrors().clear();
			action
					.addActionError(((ActionSupport) actionInvocation
							.getAction())
							.getText("login.errormsg.sessionExpire"));
			return "login";
		}
		// Check the Authentication
		boolean isAuthenticated = false;
		boolean isAuthorised = false;

		if (user != null) {

			isAuthenticated = true;
			isAuthorised = true;
		}

		if (!isAuthenticated) {
			return "login";
		}

		if (!isAuthorised) {
			return "unauthorized";
		} else {
			long timeSpan = new Date().getTime()-stTime;
			System.out.println("Exit time is : "+timeSpan+" milliSeconds.");
			return actionInvocation.invoke();
		}

	
	}

}
