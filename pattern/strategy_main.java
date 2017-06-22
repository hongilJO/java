package pattern;

public class strategy_main {
	/*
	 * 1. 인터페이스
	 * 
	 * 기능에 대한 선언과 구현 분리
	 * 
	 * -선언은 인터페이스, 구현은 implement한 객체
	 * 
	 * 기능을 통로로 사용 
	 * 
	 * 2. 델리게이트
     *
	 * 위임하다(떠넘기다)
	 * 
	 * - 어떤 기능을 가진 다른 객체를 호출하여 사용함
	 * 
	 * 3. 전략패턴
	 * 
	 * client 에서 strategy 임플리먼트를 갖고 : strategy의 기능을 구현한 a,b,c 클래스를 불러와서 입맛에 골라 사용..
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		strategy_character c1 = new strategy_character();
		c1.attack();
		c1.set_weapon(new strategy_axe());
		c1.attack();
		c1.set_weapon(new strategy_sword());
		c1.attack();
	}

}
