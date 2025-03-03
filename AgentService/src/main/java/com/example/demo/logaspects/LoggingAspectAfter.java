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
	
	@After("execution(* com.example.demo.service.AgentService.*(..))")
	public void logAfterAllAgentServiceMethods(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspect.logAfterAllAgentService() : " + joinPoint.getSignature().getName());
	}
	
	@After("execution(* com.example.demo.service.AgentService.createAgent(..))")
	public void logAfterCreateAgentMethods(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspect.logAfterCreateAgent() : " + joinPoint.getSignature().getName());
	}

}
