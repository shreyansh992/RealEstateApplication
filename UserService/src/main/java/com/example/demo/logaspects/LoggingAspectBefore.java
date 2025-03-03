package com.example.demo.logaspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
class LoggingAspectBefore {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(* com.example.demo.controller.UserAdminController.*(..))")
	public void logBeforeAllUserAdminControllerServiceMethods(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspect.logBeforeAllUserAdminControllerServiceMethods() : " + joinPoint.getSignature().getName());
	}
	
	@Before("execution(* com.example.demo.controller.UserController.*(..))")
	public void logBeforeAllUserControllerServiceMethods(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspect.logBeforeAllUserControllerServiceMethods() : " + joinPoint.getSignature().getName());
	}
	
}
