package com.pwi.ws.handler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class JAXSoapServiceHandler  implements SOAPHandler<SOAPMessageContext>
{
	private ByteArrayOutputStream	requestSoap		= new ByteArrayOutputStream ();
	private ByteArrayOutputStream	responseSoap	= new ByteArrayOutputStream ();



	/***
	 * This method called when web-service complete their execution
	 * 
	 * @param MessageContext
	 *            object that contain the message context
	 * @return nothing
	 */
	@Override
	public void close (MessageContext context)
	{
		execute ();

	}

	/***
	 * This method called when Fault exception occurred
	 * 
	 * @param SOAPMessageContext
	 *            object that contain the soap context
	 * @return nothing
	 */
	@Override
	public boolean handleFault (SOAPMessageContext context)
	{
		fetchSoapMessage (context);
		return false;
	}

	/***
	 * This method fetch the soap message as string
	 * 
	 * @param SOAPMessageContext
	 *            object that contain the soap context
	 * @return nothing
	 */
	private void fetchSoapMessage (SOAPMessageContext context)
	{

		Boolean isRequest = (Boolean) context.get (MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		
		try
		{
			SOAPMessage soapMsg = context.getMessage ();
			if (!isRequest)
				soapMsg.writeTo (requestSoap);
			else
				soapMsg.writeTo (responseSoap);

		}
		catch (SOAPException e)
		{
			e.printStackTrace ();
		}
		catch (IOException e)
		{
			e.printStackTrace ();
		}
	}

	/***
	 * This method log request response 
	 * 
	 * @param
	 * 
	 * @return nothing
	 */
	private void execute ()
	{
		
	}

	/***
	 * This method called just before execution of we-service
	 * 
	 * @param SOAPMessageContext
	 *            object that contain the soap context
	 * @return nothing
	 */
	@Override
	public boolean handleMessage (final SOAPMessageContext context)
	{

		fetchSoapMessage (context);

		return true;
	}

	@Override
	public Set<QName> getHeaders ()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
