package design_pattern;

import design_pattern_interface.fly;
import design_pattern_interface.shooting;

public class strategyPattern {
	
	/* 
	 * 스트레티지 패턴이란? 
	 *어떤 객체를 만들때 객체가 가진 다양한 기능들 중에서 공통적이며 변경할 부분은 추상화하여 언제든지 적용할 수 있게 만드는것
	 *기능을 부품화 하여 구조를 만드는것을 스트레티지라고 합니다.  
	 */
	String arm;
	String leg;
	String head;
	String body;
	
	fly ifly;
	shooting ishooting;
	/* 맨 처음 모든 기능을 다 갖고 있는 개별 클래스 생성 -> 각 클래스에서 공통적인 부분 찾아서 부모 클래스 생성(상속) ->
	 * 자식 클래스에서 다른부분이 있는 필수적인 부분은 추상메소드, 변경이 없는 공통인 부분을 일반메소드로 구현한다. 그리하여 추상 클래스 생성->
	 * 추상 메소드는 기능별로 인터페이스를 구현한뒤 그것을 구현하는 클래스를 만듬 -> 자식에서 기능을 담당하는 객체를 지정하는 setter를 만들어서 
	 * 부모에 전달 -> 기능을 실행하는 함수를 만듬. 
	 * 
	 * */
	
	public void walk(){
		System.out.println("걸을수있어요");
	};
	public void run(){
		System.out.println("달릴수있어요");
	};
	void setdofly(fly ifly){
		this.ifly=ifly;
	}
	void setdoshooting(shooting ishooting){
		this.ishooting=ishooting;
	}
	void actionfly(){
		this.ifly.fly();
	}
	void actionshooting(){
		this.ishooting.shooting();
	}
	
}



