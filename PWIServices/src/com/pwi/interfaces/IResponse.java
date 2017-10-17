package com.pwi.interfaces;
public interface IResponse 
{
	
	public IDataTransferObject getObject ();

	public String getNavigationURL ();

	public boolean bForward ();

}
