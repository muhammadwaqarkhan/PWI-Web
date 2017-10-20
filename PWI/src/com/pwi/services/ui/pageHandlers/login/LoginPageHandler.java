package com.pwi.services.ui.pageHandlers.login;

import javax.servlet.http.HttpServletRequest;

import com.pwi.constants.FrameNames;
import com.pwi.interfaces.IPageHandler;
import com.pwi.interfaces.IResponseHandler;
import com.pwi.services.base.ServiceBase;
import com.pwi.services.ui.pageHandlers.base.BasePageHandler;
import com.pwi.services.user.dto.UserAccountsInDTO;
import com.pwi.services.user.dto.UserAccountsOutDTO;
import com.pwi.spring.SpringApplicationContext;

public class LoginPageHandler extends BasePageHandler implements IPageHandler {

	@Override
	public IResponseHandler executeRead(HttpServletRequest request) {

		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		IResponseHandler response = verifyUser(userName, password);

		if (isSuccess(response, request)) {
			request.setAttribute("branches", ((UserAccountsOutDTO) response).getBranches());
			response.setNavURL(getNavUrl(request));
			return response;
		} else {
			response.setNavURL("login.jsp");
			request.setAttribute("iErrorPanel", response.getErrorString());
			return response;
		}

	}

	@Override
	public IResponseHandler executeWrite(HttpServletRequest request) {

		return null;
	}

	public IResponseHandler verifyUser(String userName, String password) {

		UserAccountsInDTO inDTO = new UserAccountsInDTO();
		inDTO.setUsername(userName);
		inDTO.setPassword(password);

		return getServiceExecutor().callService(getService(), "VarifedUser", inDTO);

	}

	private String getNavUrl(HttpServletRequest request) {

		String navUrl = FrameNames.ADMIN_DESKTOP + ".jsp";
		return navUrl;

	}

	@Override
	public IResponseHandler executeDelete(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResponseHandler executeUpdate(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ServiceBase getService() {
		return (ServiceBase) SpringApplicationContext.getBean("userAccountsService");
	}
}