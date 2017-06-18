package api;

public class api5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * wrapper class 래퍼 클래스는 기초 자료형을 객체 자료형으로 변화 시키는 클래스다.
		 * 기초자료형         객체 자료형
		 * byte            Byte
		 * short           Short
		 * int             Integer
		 * long            Long
		 * double          Double
		 * float           Float
		 * boolean         Boolean
		 * char            Character
		 */
		Integer i = new Integer(10);
		System.out.println(i.intValue());
		String si = "105";
		int iv = Integer.parseInt(si); //스트링을 인트형으로 변경하는것 
		System.out.println(iv);
	}

}
