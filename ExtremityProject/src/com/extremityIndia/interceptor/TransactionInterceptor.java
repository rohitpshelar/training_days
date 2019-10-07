package com.extremityIndia.interceptor;



import com.extremityIndia.context.CallContextService;
import com.extremityIndia.context.Context;
import com.extremityIndia.util.HibernateUtil;

import java.util.Date;

/*import org.apache.log4j.Logger;*/
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


/**
 * @author Kunal Sonu
 *
 */
public class TransactionInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 107L;

	//private static Logger logger = Logger.getLogger(TransactionInterceptor.class);
	
	public String intercept(ActionInvocation invocation) throws Exception {

		Session hibernateSession = HibernateUtil.getSession();

		long stTime = new Date().getTime();
		try {
			
			//logger.debug("Open Hibernate Session");
			System.out.println("Open Hibernate Session");
			Context ct = CallContextService.getInstance().getContext();
			if(ct==null)
				 ct =new Context();
			ct.setAttribute("hibernateSession", hibernateSession);
			CallContextService.getInstance().setContext(ct);
		//	logger.debug("Begin Transaction");
			System.out.println("Begin Transaction");
			HibernateUtil.beginTransaction();
			long timeSpan = new Date().getTime()-stTime;
			System.out.println("Exit time is : "+timeSpan+" milliSeconds.");
			return invocation.invoke();
		} catch (Exception ex) {
			System.out.println("Pradip ");
			HibernateUtil.rollbackTransaction();
		} finally {
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			/*logger.debug("close Transaction");
			logger.debug("close session");*/
			System.out.println("close Transaction");
			System.out.println("close session");
			hibernateSession = null;
		}

		return "";
	}

}
