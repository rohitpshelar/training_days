package com.extremityIndia.util;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



/**
 * @author Kunal Sonu
 *
 */
public class HibernateUtil {

	private static final SessionFactory sessionFactory;
//	private static final ServiceRegistry serviceRegistry;
	
	private static final ThreadLocal<Session> threadSession = new ThreadLocal<Session>();
	
	private static final ThreadLocal<Transaction> threadTransaction = new ThreadLocal<Transaction>();
	
	// buildSessionFactory() is deprecated in Hibernate 4
	
	static {
		try{
			Configuration configuration = new Configuration();
		    configuration.configure();
			//serviceRegistry=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		//	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			sessionFactory = configuration.buildSessionFactory(                                                                                                                                        );
		} 
		catch (Throwable ex){
			ex.printStackTrace(System.out);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession()  {
		Session s = (Session) threadSession.get();
		// open a new session, if this thread has none yet
		
		try{
			if (s == null){
				s = sessionFactory.openSession();
				threadSession.set(s);
			}
		}
		catch (HibernateException ex) {
ex.printStackTrace();
		}
		return s;
	}
	
	public static void closeSession() {
		try {
			Session s  = (Session)threadSession.get();
			threadSession.set(null);
			if (s != null && s.isOpen()){
				s.close();
			}
		}
		catch (HibernateException ex){
			ex.printStackTrace();
		}
	}
	
	public static void beginTransaction() {
		Transaction tx = (Transaction)threadTransaction.get();
		
		try {
			if (tx == null){
				tx = getSession().beginTransaction();
				threadTransaction.set(tx);
			}
		}
		catch (HibernateException ex){
			ex.printStackTrace();
		}
	}
	
	public static void commitTransaction() {
		Transaction tx = (Transaction)threadTransaction.get();
		
		try {
			if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack()){
				tx.commit();
			}
			threadTransaction.set(null);
		}
		catch (HibernateException ex){
			rollbackTransaction();
			ex.printStackTrace();
		}
	}
	
	public static void rollbackTransaction() {
		Transaction tx = (Transaction)threadTransaction.get();
		
		try {
			threadTransaction.set(null);
			if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack()){
				tx.rollback();
			}
		}
		catch (HibernateException ex){
			ex.printStackTrace();
		}
		finally {
			closeSession();
		}
	}

}
