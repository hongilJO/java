package collection;

import java.util.ArrayList;

public class list_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//arraylist 배열과 비슷하나 크기를 고정하지 않아도 됀다. 
		// 삽입, 삭제는 linkedlist가 빠르고 탐색, 정렬은 arraylist가 빠르다.
		ArrayList<String> li1 = new ArrayList<String>();
		
		li1.add("string1");// 리스트에 데이터 삽입
		li1.add("string2");
		li1.add("string3");
		li1.add("string4");
	    li1.add(4,"string5"); //해당 인덱스에 데이터 삽입 
		String s4 = "string4";
		System.out.println(li1.toString()); // 리스트객체를 스트링으로 변환 
		System.out.println(li1.get(3)); // 3번째 인덱스를 가져온다.
		System.out.println(li1.size());  // 리스트의 크기를 구한다.
		li1.set(2, "stringhahah");  // 리스트 값을 변경한다.
		System.out.println(li1.toString());
		li1.remove(2);  // 리스트 값을 삭제한다.
		System.out.println(li1.toString());
		System.out.println(li1.contains(s4)); // 리스트의 값을 검색한다.
		li1.clear(); // 리스트를 초기화한다.
		System.out.println(li1.toString());
		
	}

}
