package com.javalec.ex;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
//@WebListener
public class servletCL implements ServletContextListener {
	// 웹어플리케이션의 생성주기,즉 떠있고 죽을때는 감시하는 리스너 클래스로서 ServlerContextListener라는 인터페이스를 구현하여 만듬.
	// contextInitailized 와 contextDestroyed 추상메소드를 구현해야 한다.
	// 등록은 우선 web.xml에 <listener>  <listener-class>로 등록하여 사용할 수도 있고.
	// 두번째는 @WebListener 라고 어노테이션을 등록하여 사용할 수 있다.
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		PrintWriter wr = null;
		try {
			wr = new PrintWriter(new FileWriter("/Users/naver/Documents/workspace/jspstudy/src/com/javalec/ex/destory.txt",true));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			wr.println("웹어플리케이션이 죽었네요!!!");
			wr.close();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("웹어플리케이션 살았어요!");
	}

}
