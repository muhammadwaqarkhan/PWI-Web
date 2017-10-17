package com.pwi.services.ui.pageHandlers;

import javax.servlet.http.HttpServletRequest;

import com.pwi.constants.ApplicationCodes;
import com.pwi.constants.FrameNames;
import com.pwi.interfaces.IPageHandler;
import com.pwi.services.ui.pageHandlers.admin.AdminPageHandler;
import com.pwi.services.ui.pageHandlers.branch.BranchPageHandler;
import com.pwi.services.ui.pageHandlers.brand.product.BrandProductPageHandler;
import com.pwi.services.ui.pageHandlers.login.LoginPageHandler;
import com.pwi.services.ui.pageHandlers.product.ProductPageHandler;
import com.pwi.services.ui.pageHandlers.store.StorePageHandler;
import com.pwi.services.ui.pageHandlers.store.product.StoreProductPageHandler;



/**
 * Class to decide on which page the user is. Respective handler returns for that particular page. That handler is responsible for executing save or get
 * operation for that frame on the basis of passed action.
 * 
 * @author Waqar
 * 
 * */
public class ActionHandler
{
	public IPageHandler getPageHandler (HttpServletRequest request)
	{
		final String pageName = getPageName(request);
		if (FrameNames.LOGIN_PAGE.equals(pageName))
		{
			return new LoginPageHandler();
		}
		else if (FrameNames.LOGIN_PAGE.equals(pageName))
		{
			return new AdminPageHandler();
		}
		else if (FrameNames.ADD_BRANCH.equals(pageName))
		{
			return new BranchPageHandler();
		}
		else if (FrameNames.ADD_STORE.equals(pageName))
		{
			return new StorePageHandler();
		}
		else if (FrameNames.ADD_PRODUCT.equals(pageName))
		{
			return new ProductPageHandler();
		}
		else if (FrameNames.ADD_STORE_PRODUCT.equals(pageName))
		{
			return new StoreProductPageHandler();
		}
		else if (FrameNames.ADD_BRAND_PRODUCT.equals(pageName))
		{
			return new BrandProductPageHandler();
		}
		
		

		return null;
	}

	private String getPageName (HttpServletRequest request)
	{
		String pageName = request.getParameter(ApplicationCodes.PAGE_NAME);
		if (pageName.contains("/"))
		{
			String[] pageNameList = pageName.split("/");
			return pageNameList[1];
		}
		return pageName;
	}
}
