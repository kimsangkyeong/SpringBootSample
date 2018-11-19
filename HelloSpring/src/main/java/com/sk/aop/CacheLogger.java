package com.sk.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CacheLogger {
	@Before("execution(void set*(*))")
	public void logger(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		Object parameterValue = jp.getArgs()[0];
		
		System.out.println("Cache changed ... .");
		System.out.println(".... " + methodName + "change property : " + parameterValue);
	}
}
