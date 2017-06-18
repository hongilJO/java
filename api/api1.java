package api;

public class api1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// string 객체자료형
		// String s1=new String ("aaa"), String s2 ="aaa"; 두개는 같은 호출이다.
		String s1 = "abcd";
		String s2 = "efgh";
		String s3 = "hijk";
		System.out.println(s1.concat(s2));// abcdefgh
		System.out.println(s1.substring(3));// d
		System.out.println(s1.length());// 4
		System.out.println(s1.toUpperCase());// HIJK
		System.out.println(s1.toLowerCase());
		System.out.println(s1.charAt(2));// c
		System.out.println(s1.indexOf(3));// d
		System.out.println(s1.equals("abcd"));// true
		System.out.println(" s 1 3 ".trim());// s 1 3 안에 있는건 안빼주네 replace 써야할
		System.out.println(s1.replace("c", "b"));// abbd
		System.out.println(s1.replaceAll("ab","hahahah"));
	}
	
	/*
	 * string은 메모리를 과소비한다. 즉 String s1 = "abc"일때 s2=s1 +"def"라는 공식을 넣으면 
	 * 자바는 기존의 s1에 참조된 메모리변수에 값을 변경하는것이 아니고 새로운 메모리변수에 계산 결과값을 생성한다.
	 * 따라서 두개의 메모리 변수를 사용하게 되는것이다.이것의 대안으로 StringBuffer, StringBuilder 등장
	 */

}
