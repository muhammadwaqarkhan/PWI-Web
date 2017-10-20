package com.pwi.services.ui.pageHandlers.base;

import javax.servlet.http.HttpServletRequest;

import com.pwi.constants.FrameworkReasonCodes;
import com.pwi.interfaces.IResponseHandler;
import com.pwi.services.base.ServiceBase;
import com.pwi.services.framework.ServiceExecutor;
import com.pwi.spring.SpringApplicationContext;

public abstract class BasePageHandler 
{

	protected  abstract ServiceBase getService();
	
	protected ServiceExecutor getServiceExecutor()
	{
		ServiceExecutor executor = (ServiceExecutor) SpringApplicationContext.getBean("serviceExecutor");
		
		return executor;
	}

	
	protected boolean isSuccess(IResponseHandler response, HttpServletRequest request)
	{
		if(response.getErrorCode() == FrameworkReasonCodes.ERROR_NO)
		{
			//request.setAttribute("successPanel", "request has been completed successfully");
			return true;
		}
			
		else
		{
			request.setAttribute("iErrorPanel", response.getErrorString());
			return false;
		}
			
	}
	
	protected boolean isSuccess(IResponseHandler response, HttpServletRequest request,boolean successMessage)
	{
		if(isSuccess(response,request))
		{
			request.setAttribute("successPanel", "request has been completed successfully");
			return true;
		}
			
		return false;
			
	}
}
