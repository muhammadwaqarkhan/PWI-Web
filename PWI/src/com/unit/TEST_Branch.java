package com.unit;

import static org.junit.Assert.assertTrue;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.annotation.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pwi.interfaces.IResponseHandler;
import com.pwi.services.branch.BranchService;
import com.pwi.services.branch.dto.BranchDTO;
import com.pwi.services.hibernate.HibernateUtil;
import com.pwi.spring.SpringApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/beans.xml",
        "file:src/hibernate.cfg.xml"})
public class TEST_Branch 
{
	 @Mock
	 static SessionFactory factory;
	 static Session session;
	 static Transaction transcation;
	 BranchService branchService ;
	
	@Before
	public void setUp ()
	{
		 SpringApplicationContext.getInstance();
		factory = HibernateUtil.getSessionFactory();
		
		session=factory.openSession();    
	    transcation=session.beginTransaction(); 
		branchService = new BranchService();
		branchService.setSession(session);
	}
	
	
	@Test
	public void SaveBranch () throws Exception
	{

		
		BranchDTO inDTO= SpringApplicationContext.getApplicationContext().getBean(BranchDTO.class);
		inDTO.setBranchName("Vantiboli branch");
		inDTO.setStreet("Vantiboli address");
		inDTO.setCity("Vantiboli city");
		inDTO.setCountry("Vantiboli country");
		inDTO.setPostalCode("123");
		
		IResponseHandler response = branchService.SaveBranch(inDTO);
		
		assertTrue(response.getErrorCode() == 0);
	}
	

	@Test
	public void getBranch () throws Exception
	{

		IResponseHandler response = branchService.fetchBranch();
		
		assertTrue(response.getErrorCode() == 0);
	}
	
	
	@After
	public void tearDown() throws Throwable 
	{
		transcation.rollback();
	}
}
