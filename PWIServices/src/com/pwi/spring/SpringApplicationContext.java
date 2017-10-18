package com.pwi.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationContext implements ApplicationContextAware{

	private SpringApplicationContext()
	{
		
	}
	private static  ApplicationContext context;
	
	public static ApplicationContext getInstance()
	{
		if(context ==null)
			context = new ClassPathXmlApplicationContext("beans.xml");
		
		return context;
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context=context;
		
	}
	
	/**
	 * This is about the same as Spring's getBean(beanName), except it has its own static handle to the Spring context, so calling
	 * this method statically will give access to the beans by name in the Spring application context. As in the
	 * context.getBean(beanName) call, the caller must cast to the appropriate target class. If the bean does not exist, then a
	 * runtime BeansException will be thrown.
	 * 
	 * @param beanName
	 *            the name of the bean to get.
	 * @return an Object reference to the named bean.
	 */
	public static Object getBean (String beanName)
	{
		return context.getBean (beanName);
	}
	
	
	public static <T> T getBean (Class<T> beanClass)
	{
		return context.getBean (beanClass);
	}
	
	
	/**
	 * Returns the spring context.
	 * 
	 * @return
	 */
	public static ApplicationContext getApplicationContext ()
	{
		return context;
	}

}
