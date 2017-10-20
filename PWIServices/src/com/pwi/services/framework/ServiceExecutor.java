package com.pwi.services.framework;

import java.lang.reflect.Method;

import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.pwi.constants.FrameworkReasonCodes;
import com.pwi.dto.BaseOutDTO;
import com.pwi.interfaces.IRequestHandler;
import com.pwi.interfaces.IResponseHandler;
import com.pwi.services.base.ServiceBase;
import com.pwi.services.base.SpringServiceBase;
import com.pwi.services.framework.annotations.ServiceMethod;
import com.pwi.services.framework.exceptions.PWIException;
import com.pwi.services.hibernate.HibernateUtil;
/**
 * This utility is responsible for providing interface to initiate calls to different services. Basic purpose of introducing it is to provide a one entry point
 * for all services so that we know from where a service is initiated and we can handle exceptions/errors better. This way we will allow a user to handle
 * exceptions better.
 * 
 * @author Waqar
 * 
 */
public class ServiceExecutor 
{
	private static volatile ServiceExecutor	singleton	= null;

	
	private JdbcTemplate jdbcTemplate;    
    public void setDataSource(DataSource dataSource) {
             this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void callService(String aa)
    {
    	System.out.println("callService");
    }

    /***
	 * This method is responsible for open Hibernate session and management transaction  
	 * in case of ant exception this method will roll-back persist entity and close connection 
	 * @param ServiceBase every service must extent which ServiceBase service 
	 * serviceName: string parameter which contains serviceMethod name
	 * inDTO:	this is type of IRequestHadnler, which contain input information           
	 * @return Object any type of object 
	 */
    public Object callService(ServiceBase service, String serviceName, IRequestHandler inDTO)
	{
    	IResponseHandler response;

    	
    	SessionFactory factory = HibernateUtil.getSessionFactory();
    	
    	Session session=factory.openSession();    
    	Transaction transcation=session.beginTransaction(); 
		try
		{
			service.setSession(session);
			Method method = getServiceMethod (service , serviceName);
			if (method.getParameterTypes ().length > 0)
				response = (IResponseHandler) method.invoke (service , inDTO);
			else
				response =  (IResponseHandler) method.invoke (service);
		
			if(response.getErrorCode() == FrameworkReasonCodes.ERROR_NO)
				transcation.commit();
			else
				transcation.rollback();
			
			
		}
		catch (Exception exception)
		{

			 transcation.rollback();
			 response = new BaseOutDTO();
			 response.setErrorCode(FrameworkReasonCodes.EXECUTION_ERROR);
			 response.setErrorString(exception.getStackTrace().toString());
			 
			 return response;
			//throw new PWIException(exception,exception.getMessage(),FrameworkReasonCodes.EXECUTION_ERROR);
		}
		finally
		{
			session.close();    
		}
		
		
		return response;
		
	}
    
    /***
   	 * @Transactional:This method is responsible for  transaction  management 
   	 * in case of any exception this method will roll-back persist entity and close connection 
   	 * @param SpringServiceBase every service must extent which SpringServiceBase service 
   	 * serviceName: string parameter which contains serviceMethod name
   	 * inDTO:	this is type of IRequestHadnler, which contain input information           
   	 * @return Object any type of object 
   	 */
	@Transactional
	public Object callService (SpringServiceBase service, String serviceName, IRequestHandler inDTO)
	{
		Object response;
		try
		{
			service.setTemplace(jdbcTemplate);
			Method method = getServiceMethod (service , serviceName);
			if (method.getParameterTypes ().length > 0)
				response= method.invoke (service , inDTO);
			else
				response= method.invoke (service);
		}
		catch (Exception exception)
		{
			throw new PWIException(exception,exception.getMessage(),FrameworkReasonCodes.EXECUTION_ERROR);
		}
		
		return response;
		
	}
	  /***
   	 * @Transactional:This method is responsible for  transaction  management 
   	 * in case of any exception this method will roll-back persist entity and close connection 
   	 * @param SpringServiceBase every service must extent which SpringServiceBase service 
   	 * serviceName: string parameter which contains serviceMethod name
   	 * inDTO:	this is type of IRequestHadnler, which contain input information           
   	 * @return Object any type of object 
   	 */
	@Transactional
	public Object callService (SpringServiceBase service, String serviceName, Object inDTO)
	{
		try
		{
			service.setTemplace(jdbcTemplate);
			Method method = getServiceMethod (service , serviceName);
			if (method.getParameterTypes ().length > 0)
				return method.invoke (service , inDTO);
			else
				return method.invoke (service);
		}
		catch (Exception exception)
		{
			throw new PWIException(exception,exception.getMessage(),-1);
		}
		
	}
	
	  /***
   	 * ServiceBase method is responsible to find those service method which have annotation of ServiceMethod
   	 *  
   	 * @param ServiceBase instance of service to find method
   	 * serviceName: string parameter which contains serviceMethod name
   	 *            
   	 * @return Method if method found then return method 
   	 */
	public Method getServiceMethod (ServiceBase service, String serviceName)
	{
		try
		{
			if (StringUtils.isBlank(serviceName))
			{
				throw new PWIException(new Exception(),"service not found",FrameworkReasonCodes.SERVICE_NOT_DEFINED);
			}

			Method[] methods = service.getClass ().getDeclaredMethods ();
			for (Method method : methods)
			{
				ServiceMethod serviceMethod = method.getAnnotation (ServiceMethod.class);
				if (serviceMethod != null && isServiceMethod (serviceMethod , serviceName))
				{
					return method;
				}
			}

			throw new PWIException(new Exception(),"service not found",FrameworkReasonCodes.SERVICE_NOT_DEFINED);
		}
		catch (Exception e)
		{
			throw new PWIException(new Exception(),"service not found",FrameworkReasonCodes.SERVICE_NOT_DEFINED);
		}
	}

	  /***
   	 * SpringServiceBase method is responsible to find those service method which have annotation of ServiceMethod
   	 *  
   	 * @param ServiceBase instance of service to find method
   	 * serviceName: string parameter which contains serviceMethod name
   	 *            
   	 * @return Method if method found then return method 
   	 */
	public Method getServiceMethod (SpringServiceBase service, String serviceName)
	{
		try
		{
			if (StringUtils.isBlank(serviceName))
			{
				throw new PWIException(new Exception(),"service not found",FrameworkReasonCodes.SERVICE_NOT_DEFINED);
			}

			Method[] methods = service.getClass ().getDeclaredMethods ();
			for (Method method : methods)
			{
				
				ServiceMethod serviceMethod = method.getAnnotation (ServiceMethod.class);
				if (serviceMethod != null && isServiceMethod (serviceMethod , serviceName))
				{
					return method;
				}
			}

			throw new PWIException(new Exception(),"service not found",FrameworkReasonCodes.SERVICE_NOT_DEFINED);
		}
		catch (Exception e)
		{
			throw new PWIException(new Exception(),"service not found",FrameworkReasonCodes.SERVICE_NOT_DEFINED);
		}
	}

	public boolean isServiceMethod (ServiceMethod serviceMethod, String serviceName)
	{
		for (int services = 0; services < serviceMethod.name ().length; services++)
		{
			if (serviceName.toUpperCase ().equals (serviceMethod.name ()[services].toUpperCase ()))
			{
				return true;
			}
		}
		return false;
	}

	
}
