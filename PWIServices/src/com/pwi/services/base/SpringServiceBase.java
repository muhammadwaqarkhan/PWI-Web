package com.pwi.services.base;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pwi.interfaces.IRequestHandler;
import com.pwi.interfaces.IResponseHandler;
public abstract class SpringServiceBase
{
	
	protected JdbcTemplate jdbcTemplate;
	
	public void setTemplace(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
   }
	public JdbcTemplate getJdbcTemplate() {
        return this.jdbcTemplate ;
   }
	
	
	public IResponseHandler execute (IRequestHandler dto)
	{
		return null;
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
