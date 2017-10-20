package com.unit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.annotation.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pwi.services.hibernate.HibernateUtil;
import com.pwi.services.store.StoreService;
import com.pwi.spring.SpringApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/beans.xml",
        "file:src/hibernate.cfg.xml"})
public class TEST_Store 
{
	 @Mock
	 static SessionFactory factory;
	 static Session session;
	 static Transaction transcation;
	 StoreService storeService ;
	 
	 
	@Before
	public void setUp ()
	{
		SpringApplicationContext.getInstance();
		factory = HibernateUtil.getSessionFactory();
			
		session=factory.openSession();    
		transcation=session.beginTransaction(); 
		storeService  = new StoreService();
		storeService .setSession(session);
	}
	
	@Test
	public void addStore()
	{
		
	}
	
	@Test
	public void updateStore () throws Exception
	{
		
	}
}
