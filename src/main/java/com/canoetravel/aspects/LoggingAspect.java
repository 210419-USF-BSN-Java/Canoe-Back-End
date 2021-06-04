package com.canoetravel.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private static Logger log = LogManager.getLogger(LoggingAspect.class);

	@Before("within(com.caneotravel.entities.*)")
	public void logModelMethods(JoinPoint jp) {
		log.info(jp.getTarget() + " invoked " + jp.getSignature());
	}

	@Before("within(com.caneotravel.*)")
	public void logAllMethods(JoinPoint jp) {
		log.info(jp.getTarget() + " invoked " + jp.getSignature());
	}

	@After("execution(void get*(..))")
	public void logGetterMethods(JoinPoint jp) {
		log.info(jp.getTarget() + "invoked a getter.");

	}

}