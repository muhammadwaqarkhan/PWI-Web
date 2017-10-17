package com.pwi.dto;

import com.pwi.interfaces.IResponseHandler;

public class BaseDTO implements IResponseHandler
{
	private int errorCode=0;
	private String errorString;
	private String navURL;


	private boolean				bForward	= true;

	@Override
	public int getErrorCode() {

		return this.errorCode;
	}

	@Override
	public String getErrorString() {

		return this.errorString;
	}
	
	
	@Override
	public void setErrorCode(int errorCode) {

		this.errorCode=errorCode;
	}

	@Override
	public void  setErrorString(String errorString) {

		this.errorString=errorString;
	}

	@Override
	public String getNavURL() {

		return navURL;
	}

	@Override
	public void setNavURL(String url) {
		this.navURL=url;
		
	}

	public boolean isbForward() {
		return bForward;
	}

	public void setbForward(boolean bForward) {
		this.bForward = bForward;
	}

	@Override
	public boolean bForward() {

		return isbForward();
	}

}
