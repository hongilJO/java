package api;

import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;

public class api6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// 타이머 객체는 일정한 시간이 되면 타임태스크 객체를 실행하게 된다. 타이머 테스크 객체는 추상클래스다. 따라서 추상메소드를 오버라이딩 해야한다.
		Timer t = new Timer(true); // true를 매개변수로 안주면 이 메인이 끝나도 해당 객체가 계속 호출된다.
		TimerTask tt1 = new timeTask1();
		TimerTask tt2 = new timeTask2();
         
		t.scheduleAtFixedRate(tt1, 3000, 1000); // schedulAtFixedRate(timetask,처음 시작 딜레이, 매번 실행시 딜레이 시간)
		t.schedule(tt2, 5000);

		Thread.sleep(10000); //타임 테스크가 실행되는동안 메인함수가 정지되지 않게 슬립을 걸어놈 
		System.out.println("종료합니다.");
		
		String word1 = "오늘 날씨가 참 좋네요";
		String word2 = "2017/06/18";
		StringTokenizer st1 = new StringTokenizer(word1);
		StringTokenizer st2 = new StringTokenizer(word2, "/"); //흠 쌍따옴표를 써야하네 자바에서는.. 파이썬은 '', "" 둘다되었는데...
	    System.out.println(st1.countTokens()); //나눠진 개수를 측정 
	    System.out.println(st2.countTokens());
	    while(st1.hasMoreTokens()){
	    	System.out.print(st1.nextToken()+"/"); //다음 토큰이 있으면 하나씩 가져온다.
	    	System.out.print(st2.nextToken()+" "); //java.util.NoSuchElementException
	    }
	    
	    
	}
}
