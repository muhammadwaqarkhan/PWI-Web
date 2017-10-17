package com.pwi.interfaces;

public interface IResponseHandler extends IDataTransferObject
{
	String getNavURL();
	void setNavURL(String url);
	int getErrorCode();
	String getErrorString();
	 boolean bForward ();
	 void setErrorCode(int errorCode);
	 void  setErrorString(String errorString);
	 void setbForward(boolean bForward);

}
