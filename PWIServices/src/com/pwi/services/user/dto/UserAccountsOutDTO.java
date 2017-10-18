package com.pwi.services.user.dto;

import org.springframework.stereotype.Component;

import com.pwi.domain.user.UserAccounts;
import com.pwi.dto.BaseDTO;
import com.pwi.spring.SpringApplicationContext;

@Component
public class UserAccountsOutDTO extends BaseDTO
{

	private static final long		serialVersionUID	= 2052370365803590280L;

	private UserAccounts	userAccount;

	
	public UserAccounts getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccounts userAccount) {
		this.userAccount = userAccount;
	}



	
	
}
