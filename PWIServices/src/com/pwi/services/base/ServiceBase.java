package com.pwi.services.base;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

import org.hibernate.Session;

import com.pwi.interfaces.IRequestHandler;
import com.pwi.interfaces.IResponseHandler;
/**
 * A base class for application services. inject session object and copy beans.
 * 
 * @author gwilliams
 */
public abstract class ServiceBase
{
	
	private Session session;
	
	public void setSession(Session session) {
        this.session = session;
   }
	
	public Session  getSession() {
        return this.session ;
   }

	public IResponseHandler execute (IRequestHandler dto)
	{
		return null;
		
	}
	
	protected ServiceBase newInstance(ServiceBase base)
	{
		base.setSession(getSession());
		return base;
	}
	
	
	

	public static <X, Y> Y copyBeans (final X source, final Y destination)
	{
		boolean isCopySuccessful = true;
		try
		{
			for (PropertyDescriptor donorDescriptor : Introspector.getBeanInfo (source.getClass ()).getPropertyDescriptors ())
			{
				if (donorDescriptor.getReadMethod () != null && !"class".equals (donorDescriptor.getName ()))
				{
					for (PropertyDescriptor descriptor : Introspector.getBeanInfo (destination.getClass ()).getPropertyDescriptors ())
					{
						if (donorDescriptor.getName ().equals (descriptor.getName ()))
						{
							descriptor.getWriteMethod ().invoke (destination , donorDescriptor.getReadMethod ().invoke (source));
							break;
						}
					}
				}
			}
		}
		catch (IllegalAccessException e)
		{
			isCopySuccessful = false;
			e.printStackTrace ();
		}
		catch (IllegalArgumentException e)
		{
			isCopySuccessful = false;
			e.printStackTrace ();
		}
		catch (InvocationTargetException e)
		{
			isCopySuccessful = false;
			e.printStackTrace ();
		}
		catch (IntrospectionException e)
		{
			isCopySuccessful = false;
			e.printStackTrace ();
		}
		catch (Exception e)
		{
			isCopySuccessful = false;
			e.printStackTrace ();
		}

		if (!isCopySuccessful)
			return null;

		return destination;
	}

	public void log (String str)
	{
		System.out.println (str);
	}

}
