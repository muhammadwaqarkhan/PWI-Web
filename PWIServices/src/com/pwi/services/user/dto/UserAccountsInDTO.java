package com.pwi.services.user.dto;

import com.pwi.interfaces.IRequestHandler;

public class UserAccountsInDTO implements IRequestHandler
{

	private String	username	= "";

	private String	password	= "";
	
	
	private boolean	isthroughuser = true;

	public String getUsername ()
	{
		return username;
	}

	public void setUsername (String username)
	{
		this.username = username;
	}

	public String getPassword ()
	{
		return password;
	}

	public void setPassword (String password)
	{
		this.password = password;
	}

	

	public boolean isIsthroughuser() {
		return isthroughuser;
	}

	public void setIsthroughuser(boolean isthroughuser) {
		this.isthroughuser = isthroughuser;
	}

	
}