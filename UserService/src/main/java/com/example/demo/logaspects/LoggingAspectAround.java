package com.example.demo.logaspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectAround {
		
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Around("execution( com.example.demo.service.UserService.findUserById(..))")
	public void logAroundfindUserById(ProceedingJoinPoint joinPoint) throws Throwable {

		LOGGER.debug("****LoggingAspect.logAroundFindUserById() : " + joinPoint.getSignature().getName()
				+ ": Before Method Execution");
		joinPoint.proceed();

		LOGGER.debug("****LoggingAspect.logAroundFindUserById() : " + joinPoint.getSignature().getName()
				+ ": After Method Execution");
	}
}
