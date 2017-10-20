package com.pwi.services.user.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pwi.domain.user.UserAccounts;
import com.pwi.dto.BaseDTO;

@Component
public class UserAccountsOutDTO extends BaseDTO {

	private static final long serialVersionUID = 2052370365803590280L;

	private UserAccounts userAccount;

	private List<UserDesktopDTO> branches = new ArrayList<UserDesktopDTO>();

	public UserAccounts getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccounts userAccount) {
		this.userAccount = userAccount;
	}

	public List<UserDesktopDTO> getBranches() {
		return branches;
	}

	public void setBranches(List<UserDesktopDTO> branches) {
		this.branches = branches;
	}

}
