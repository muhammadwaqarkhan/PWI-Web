package com.pwi.services.ui.pageHandlers;

import javax.servlet.http.HttpServletRequest;

import com.pwi.constants.ApplicationCodes;
import com.pwi.interfaces.IPageHandler;
import com.pwi.services.ui.pageHandlers.base.Pagehandler;

/**
 * Class to decide on which page the user is. Respective handler returns for
 * that particular page. That handler is responsible for executing save or get
 * operation for that frame on the basis of passed action.
 * 
 * @author Waqar
 * 
 * */
public class ActionHandler {
	public IPageHandler getPageHandler(HttpServletRequest request) {
		final String pageName = getPageName(request);

		return Pagehandler.getPageHandler(pageName);

	}

	private String getPageName(HttpServletRequest request) {
		String pageName = request.getParameter(ApplicationCodes.PAGE_NAME);
		if (pageName.contains("/")) {
			String[] pageNameList = pageName.split("/");
			return pageNameList[1];
		}
		return pageName;
	}
}
