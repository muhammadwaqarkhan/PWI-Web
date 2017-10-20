package com.pwi.services.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil 
{
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	  /***
   	 * this method is responsible to build hibernate.cfg.xml file which contain data-source and entity mapping
   	 *  
   	 * @param SessionFactory instance of service to find method
   	 *            
   	 * @return SessionFactory 
   	 */
	@SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() 
	{
		Configuration cfg=new Configuration();    
    	cfg.configure("hibernate.cfg.xml");  
    	SessionFactory factory=cfg.buildSessionFactory();
    	return factory;
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}

}
