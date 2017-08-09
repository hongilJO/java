package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {
	
	public void afterThrowingLog(JoinPoint jp, Exception exceptObj){
		// 비지니스 로직 수행중 발생한 에러를 확인 하기 위해서 exception을 바인드 변수로 넣어준다. 
		String method = jp.getSignature().toLongString();
		
		System.out.println("[예외 처리] " + method + "() 메소드 수행중 발생된 예외 메시지 :" + exceptObj.getMessage());
	}
}
