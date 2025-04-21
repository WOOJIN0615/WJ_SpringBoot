package com.woojin.app.aoptest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect //어떤 advice를 어떤 point-cut에 언제 실행할 것인지를 설정
public class Card {
	
	@Before("execution( * com.woojin.app.aoptest.Transport.bicycle(*))")
	public void useMoblie(JoinPoint jp) throws Throwable {
		System.out.println("앱 결제");
	}
	
	@Around("execution( * com.woojin.app.aoptest.Transport.get*(*))")
	public Object cardCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("삑.");
//		System.out.println(joinPoint.getKind());
//		System.out.println(joinPoint.getTarget());
		Object [] ar = joinPoint.getArgs();
		for (Object obj : ar) {
			System.out.println("Args : "+obj.toString());
		}
		Object obj=joinPoint.proceed();
		System.out.println(obj.toString());
		System.out.println("하차입니다.");
		
		String result = "OK";
		
		return result;
	}
}
