package com.pwi.services.user;

import com.pwi.constants.FrameworkReasonCodes;
import com.pwi.dao.user.UserAccountsDAO;
import com.pwi.domain.user.UserAccounts;
import com.pwi.interfaces.IResponseHandler;
import com.pwi.services.base.ServiceBase;
import com.pwi.services.framework.annotations.ServiceMethod;
import com.pwi.services.user.dto.UserAccountsInDTO;
import com.pwi.services.user.dto.UserAccountsOutDTO;
public class UserAccountsService extends ServiceBase{

	/***
	 * This method called to Verified user authenticate 
	 * 
	 * @param UserAccountDTO which contain user/password
	 *            
	 * @return IResponseHandler status of request and user object
	 */
	@ServiceMethod(name = "VarifedUser")
	public IResponseHandler varifedUser(UserAccountsInDTO o) 
	{
		UserAccountsOutDTO outDTO = new UserAccountsOutDTO();
		UserAccountsInDTO dto = (UserAccountsInDTO) o;
		
		UserAccounts user=	UserAccountsDAO.getInstance(getSession()).readUser(dto.getUsername( ), dto.getPassword( ));
		
		if(user ==null)
		{
			outDTO.setErrorCode(FrameworkReasonCodes.GENERAL_ERROR);
			outDTO.setErrorString("invalid user details");
		}
			
		outDTO.setUserAccount(user);
		return outDTO;
	}
}
	

