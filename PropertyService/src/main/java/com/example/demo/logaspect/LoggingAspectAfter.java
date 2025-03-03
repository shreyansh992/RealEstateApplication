package com.example.demo.logaspect;

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
	
	@After("execution(* com.example.demo.service.PropertyService.*(..))")
	public void logAfterAllPropertyServiceMethods(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspect.logAfterAllPropertyServiceMethods() : " + joinPoint.getSignature().getName());
	}
	
	@After("execution(* com.example.demo.service.PropertyService.createProperty(..))")
	public void logAfterCreatePropertyMethods(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspect.logAfterCreatePropertyMethods() : " + joinPoint.getSignature().getName());
	}

}
