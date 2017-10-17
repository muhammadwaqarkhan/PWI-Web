package com.pwi.services.ui.pageHandlers.base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pwi.services.framework.ServiceExecutor;

public class BasePageHandler 
{
	private static ApplicationContext context;
	private BasePageHandler()
	{
		//make is singalton
	}
	public static ServiceExecutor getServiceExecutor()
	{
		if(context ==null)
			context = new ClassPathXmlApplicationContext("beans.xml");
		
		ServiceExecutor executor = (ServiceExecutor) context.getBean("serviceExecutor");
		
		return executor;
	}

}
