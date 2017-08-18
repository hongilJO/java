package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	@Pointcut("execution(* com.springbook.biz.user..*Impl.get*(..))")
	public void getPointcut(){
		
	}
	
	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
	public void allPointcut(){
		
	}
}
