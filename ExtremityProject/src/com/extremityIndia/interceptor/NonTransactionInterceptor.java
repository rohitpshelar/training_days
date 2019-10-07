package com.extremityIndia.interceptor;


import com.extremityIndia.context.CallContextService;
import com.extremityIndia.context.Context;
import com.extremityIndia.util.HibernateUtil;


import java.util.Date;

import org.hibernate.Session;


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


/**
 * @author Kunal Sonu
 *
 */
public class NonTransactionInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 107L;


	public String intercept(ActionInvocation invocation) throws Exception {
		Session hibernateSession = HibernateUtil.getSession();
		String result = "";
		long stTime = new Date().getTime();
		try {

			Context ct = CallContextService.getInstance().getContext();
			if(ct==null)
				 ct =new Context();
			ct.setAttribute("hibernateSession", hibernateSession);
			CallContextService.getInstance().setContext(ct);

			//HibernateUtil.beginTransaction();
			
			result = invocation.invoke();
		} catch (Exception ex) {
			HibernateUtil.rollbackTransaction();
		} finally {
			//HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			hibernateSession = null;
		}
		long timeSpan = new Date().getTime()-stTime;
		System.out.println("Exit time is : "+timeSpan+" milliSeconds.");
		return result;
	}

}
