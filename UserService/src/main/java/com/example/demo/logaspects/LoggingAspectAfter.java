package com.example.demo.logaspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectAfter {
	
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@After("execution(* com.example.demo.service.UserService.*(..))")
	public void logBeforeAllAccountServiceMethods(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspect.logAfterAllUserService() : " + joinPoint.getSignature().getName());
	}
	
	@After("execution(* com.example.demo.service.UserService.createUser(..))")
	public void logBeforeAllTransactionServiceMethods(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspect.logAfterCreateUser() : " + joinPoint.getSignature().getName());
	}
}
