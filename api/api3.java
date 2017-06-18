package api;

import java.util.Random;

public class api3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 랜덤한 숫자를 구하는 작업, Math.random (before)  random 클래스 (after) 
		 * double d = Math.random(); 클래스메소드 	0 ~ 1 사이의 실수 
		 * Random r = new Random();  r.nextInt(100); 100미만의 난수 생성	 
		 */
		 double d = Math.random();
		 System.out.println(String.format("%-5.2f",d));
		 int di=(int)(d*100); //계산을 먼저 할수 있도록 괄호를 표기하자..
		 System.out.println(di);
		 Random r = new Random();
		 int i = r.nextInt(100);
		 System.out.println(i);
	}

}
