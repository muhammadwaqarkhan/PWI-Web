package com.pwi.services.ui.pageHandlers.login;

import javax.servlet.http.HttpServletRequest;

import com.pwi.constants.FrameNames;
import com.pwi.dto.BaseOutDTO;
import com.pwi.interfaces.IPageHandler;
import com.pwi.interfaces.IResponseHandler;
import com.pwi.services.base.ServiceBase;
import com.pwi.services.framework.ServiceExecutor;
import com.pwi.services.ui.pageHandlers.base.BasePageHandler;
import com.pwi.services.user.UserAccountsService;
import com.pwi.services.user.dto.UserAccountsInDTO;
import com.pwi.services.user.dto.UserAccountsOutDTO;

public class LoginPageHandler   implements IPageHandler {

	@Override
	public IResponseHandler executeRead(HttpServletRequest request) {

		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		IResponseHandler response = verifyUser(userName, password);
		response.setNavURL(getNavUrl(request));
		return response;
	}

	@Override
	public IResponseHandler executeWrite(HttpServletRequest request) {

		return null;
	}

	public IResponseHandler verifyUser(String userName, String password) {
	
		ServiceExecutor executor = BasePageHandler.getServiceExecutor();

		UserAccountsInDTO inDTO = new UserAccountsInDTO();
		inDTO.setUsername(userName);
		inDTO.setPassword(password);

		ServiceBase service = new UserAccountsService();
		
		Object object = executor.callService(service, "VarifedUser", inDTO);
		if(object instanceof UserAccountsOutDTO)
		{
			return (UserAccountsOutDTO)object;
			
		}
		BaseOutDTO errorOutDTO = new BaseOutDTO();
		return errorOutDTO;
	}
	
	private String getNavUrl (HttpServletRequest request)
	{
		
		String navUrl = FrameNames.ADMIN_DESKTOP+".jsp";
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
}