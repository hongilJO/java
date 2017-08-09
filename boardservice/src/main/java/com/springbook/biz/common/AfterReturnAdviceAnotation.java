package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserDTO;

/*
@Service
@Aspect
*/
public class AfterReturnAdviceAnotation {
	@Pointcut("execution(* com.springbook.biz.user..*Impl.get*(..))")
	public void afterReturnPointcut(){
		
	}
	@AfterReturning(pointcut="afterReturnPointcut()", returning="returnObj")
	public void afterReturnLog(JoinPoint jp, Object returnObj){
	    // 비지니스 로직 수행 후 리턴한 결과값을 확인하기 위해 object 를 바인딩 변수로 넣어준다. 
		String method = jp.getSignature().getName();
		String args = jp.getArgs()[0].toString();
		
		if (returnObj instanceof UserDTO){
			UserDTO user = (UserDTO) returnObj;
			System.out.println(user.getRole()+"님의 접속을 환영합니다.");
		}
		
		System.out.println("[사후 처리] " + method + "매개 변수값 :" + args);
	}
}
