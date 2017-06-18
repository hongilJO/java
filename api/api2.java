package api;

import java.util.Calendar;

public class api2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * StringBuilder와 StringBuffer는 약간의 차이가 있을뿐 같다고 생각하면 된다.
		 * StringBuilder가 StringBuffer 나중에 나왔고 기능은 비슷하며 속도면에서 빠르다.
		 */
		StringBuilder sb= new StringBuilder("abcdefg");
		System.out.println(sb.append("hijk"));//abcdefghijk
		System.out.println(sb.insert(2,"ABCD"));//abABCDcdefghijk
		System.out.println(sb.delete(2, 4));//abCDcdefghijk  뒤에서 -1만큼까지 빼진다.
		System.out.println(sb.deleteCharAt(5));//abCDcefghijk
	    String s1="abCDcdfghijk";
	    System.out.println(s1.equals(sb)); //string과  stringbuilder 값은 같아도 비교하면 false로 나옴 
	    
	    
	    /* 날짜와 시간에 쓰이는 calendar api (singleton으로 구현됌)
	     */
	    System.out.println(System.currentTimeMillis());
	    Calendar calendar = Calendar.getInstance();
	    int year = calendar.get(Calendar.YEAR);
	    int month = calendar.get(calendar.MONTH)+1; //월은 +1일 해줘야 현재와 같은값이 나와
	    int day = calendar.get(calendar.DAY_OF_MONTH);
	    int hour = calendar.get(calendar.HOUR_OF_DAY); // 24시간 기준 
	    int min = calendar.get(calendar.MINUTE);
	    System.out.println(year+"/"+month+"/"+day+" "+hour+min);
	}

}
