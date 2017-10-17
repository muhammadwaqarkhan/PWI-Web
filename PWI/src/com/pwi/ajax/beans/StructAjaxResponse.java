package com.pwi.ajax.beans;

import java.io.Serializable;

public class StructAjaxResponse implements Serializable
{

	private static final long	serialVersionUID	= 4814535401419301656L;

	private String				error				= "";

	private String				htmlString			= "";

	private String				javaScript			= "";

	private Object				userData			= null;

	public String getError ()
	{
		return error;
	}

	public void setError (String error)
	{
		this.error = error;
	}

	public String getHtmlString ()
	{
		return htmlString;
	}

	public void setHtmlString (String htmlString)
	{
		this.htmlString = htmlString;
	}

	public String getJavaScript ()
	{
		return javaScript;
	}

	public void setJavaScript (String javaScript)
	{
		this.javaScript = javaScript;
	}

	public Object getUserData ()
	{
		return userData;
	}

	public void setUserData (Object userData)
	{
		this.userData = userData;
	}

}
