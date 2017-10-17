package com.pwi.services.framework.exceptions;

public class PWIException extends RuntimeException
{
	private static final long	serialVersionUID	= -6465601491107791901L;

	private String message;
	private Exception excaption;
	
	private int Code;
	public PWIException (Exception ex,String message, int code)
	{
	
		this.message=message;
		this.Code=code;
		this.excaption=ex;
	}
	public String getMessage ()
	{
		return message;
	}

	public  int getErrorCode ()
	{
		return Code;
	}
	public Exception getExcaption() {
		return excaption;
	}
	public void setExcaption(Exception excaption) {
		this.excaption = excaption;
	}

	
}
