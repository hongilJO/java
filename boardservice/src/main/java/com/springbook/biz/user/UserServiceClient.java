package com.springbook.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("applicationContext.xml");
		UserService userService = ctx.getBean("userService", UserServiceImpl.class);
		
		UserDTO dto = new UserDTO();
		dto.setId("test");
		dto.setPassword("test123");
		
		UserDTO user = userService.getUser(dto);
		
		if(user != null){
			System.out.println(user.getName()+ "님 환영합니다.");
		}else{
			System.out.println("로그인 실패");
		}
		ctx.close();
	}

}
