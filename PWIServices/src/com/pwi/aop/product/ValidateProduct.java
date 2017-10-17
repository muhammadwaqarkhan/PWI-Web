package com.pwi.aop.product;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidateProduct {
	/*@Before("execution(* com.pwi.services.product.saveProduct(*))")
	private void validateProduct(JoinPoint joinPoint)
	{
		System.out.println("@Before");
	}*/
}
