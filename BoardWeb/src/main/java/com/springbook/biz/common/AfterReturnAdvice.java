package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

import com.springbook.biz.user.UserDTO;

public class AfterReturnAdvice {

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
