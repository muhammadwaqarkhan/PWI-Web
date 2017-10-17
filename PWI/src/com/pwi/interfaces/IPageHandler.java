package com.pwi.interfaces;

import javax.servlet.http.HttpServletRequest;

public interface IPageHandler
{
	public IResponseHandler executeRead (HttpServletRequest request);

	public IResponseHandler executeWrite (HttpServletRequest request);
	
	public IResponseHandler executeDelete (HttpServletRequest request);
	
	public IResponseHandler executeUpdate (HttpServletRequest request);
}
