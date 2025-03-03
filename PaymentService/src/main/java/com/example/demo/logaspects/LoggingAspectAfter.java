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
	
	@After("execution(* com.example.demo.service.PaymentService.*(..))")
	public void logAfterAllPaymentServiceMethods(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspect.logAfterAllPaymentServiceMethods() : " + joinPoint.getSignature().getName());
	}
	
	@After("execution(* com.example.demo.service.PaymentService.createPayment(..))")
	public void logAfterCreatePaymentMethods(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspect.logAfterCreatePaymentMethods() : " + joinPoint.getSignature().getName());
	}

}
