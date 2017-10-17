package com.pwi.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 
 */
@Component
@Aspect
public class ProxyTranscationManager 
{
	@Before("execution(* com.pwi.services.framework.ServiceExecutor.callService(*))")
	private void begainTranscation(JoinPoint joinPoint)
	{
		System.out.println("@Before");
	}
	
	
	@After("execution(* com.pwi.services.framework.ServiceExecutor.callService(*))")
	private void closeTranscation(JoinPoint joinPoint)
	{
		System.out.println("@@After");
	}

}
