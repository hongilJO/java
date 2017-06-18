package api;

import java.util.Scanner;

public class api4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		// scanner 키보드에서 타이핑 하는 문자열 또는 입출력 프로그래밍에서 문자열 읽어올때 사용한다.
		
		Scanner s = new Scanner(System.in);
		
		String sl = s.nextLine();// 입력을 문자열로 받는데 개행문자까지 읽고 뒤에는 버림.'
		System.out.format("입력값은 %s입니다.",sl);
		
		int i = s.nextInt();// 여기서 input을 기다리고 있음 마지막에 \n 개행문자가 추가됌.따라서 nextLine() 앞에 호출하면 nextLine수행이 안되고 끝남.
		System.out.format("입력값은 %d 입니다.",i);
		/*
		String ss= s.next();//문자 받을때 이렇게 함. 띄어쓰기 하면 앞부분만 읽어옴..마지막에 \n 개행문자가 추가됌.
		System.out.format("입력값은 %s입니다.", ss); 따라서 nextLine() 앞에 호출하면 nextLine수행이 안되고 끝남. 왜냐하면 nextLine은\n까지만 읽기때문에  
		*/
		
	}

}
