package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		// around advice 에서는 반드시 proceedingjoinpoint 사용을 해야한다. 
		System.out.println("[BEFORE]: 비지니스 메소드 수행 전에 처리할 내용");
		Object returnobj =  pjp.proceed();
		// pjp.proceed() 함수 호출후에 리턴되는 returnobj는 비지니스 로직 실행 후 리턴되는 객체 
		System.out.println("[AFTER]: 비지니스 메소드 수행 후에 처리할 내용");
		System.out.println(returnobj.toString());
		// 객체를 넘겨줘도 되고 안넘겨줘도 된다. 로직에 따라 변경하는것 
		return returnobj;
	}
}
