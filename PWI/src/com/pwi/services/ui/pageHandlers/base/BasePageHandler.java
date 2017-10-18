package com.pwi.services.ui.pageHandlers.base;

import com.pwi.services.framework.ServiceExecutor;
import com.pwi.spring.SpringApplicationContext;

public class BasePageHandler 
{

	private BasePageHandler()
	{
		//no ne
	}
	public static ServiceExecutor getServiceExecutor()
	{
		ServiceExecutor executor = (ServiceExecutor) SpringApplicationContext.getApplicationContext().getBean("serviceExecutor");
		
		return executor;
	}

}
