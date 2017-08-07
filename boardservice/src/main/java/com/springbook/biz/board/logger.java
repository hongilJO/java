package com.springbook.biz.board;

public class logger {
	
	public void beforePrintLog(){
		System.out.println("[공통 로그- LOG4J] 비지니스 로직 수행 전 동작");
	}
	public void after_returnPrintLog(){
		System.out.println("[사후 처리 로그- LOG4J] 비지니스 로직 수행 후 동작");
	}
	public void after_throwingPrintLog(){
		System.out.println("[사후 처리 로그- LOG4J] 비지니스 로직 수행중 예외 발생시 동작");
	}
	public void afterPrintLog(){
		System.out.println("[사후 처리 로그- LOG4J] 비지니스 로직 수행후 무조건 동작");
	}
}
