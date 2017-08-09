package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
/*
@Service
@Aspect
*/
public class AfterThrowingAdviceAnotation {
	@Pointcut("execution(* com.springbook.biz.board..*Impl.*(..))")
	public void afterThrowingPointcut(){
		
	}
	
	@AfterThrowing(pointcut="PointcutCommon.allPointcut()",throwing="exceptObj")
	public void afterThrowingLog(JoinPoint jp, Exception exceptObj){
		// 비지니스 로직 수행중 발생한 에러를 확인 하기 위해서 exception을 바인드 변수로 넣어준다. 
		String method = jp.getSignature().toLongString();
		
		System.out.println("[예외 처리] " + method + "() 메소드 수행중 발생된 예외 메시지 :" + exceptObj.getMessage());
	}
}
