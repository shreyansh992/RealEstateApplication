package com.example.demo.logaspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectBefore {

		private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
		
		@Before("execution(* com.example.demo.service.BookingService.*(..))")
		public void logBeforeAllPropertyServiceMethods(JoinPoint joinPoint) {
			LOGGER.info("****LoggingAspect.logBeforeAllPropertyServiceMethods() : " + joinPoint.getSignature().getName());
		}
		
		@Before("execution(* com.example.demo.service.BookingService.updateBooking(..))")
		public void logBeforeUpdateBookingMethods(JoinPoint joinPoint) {
			LOGGER.info("****LoggingAspect.logBeforeUpdateBookingMethods() : " + joinPoint.getSignature().getName());
		}
}
