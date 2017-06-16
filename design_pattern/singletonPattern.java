package design_pattern;

    /* 싱글턴 패턴이란 어떤 클래스의 인스턴스는 오직 하나임을 보장하며, 이 인스턴스에 접근할 수 있는 
       전역적인 접촉점을 제공하는 패턴이다.
    */
public class singletonPattern {

	private static singletonPattern SINGLE = new singletonPattern();
	
	/*
	 * 클래스 변수 작성하고 싶은것 작성 
	 */
	private singletonPattern(){
		
	}
	
	public static singletonPattern get_singletonPattern(){
		if(SINGLE==null){
			SINGLE=new singletonPattern();
		}
		return SINGLE;
	}
	/*
	 * 인스턴스 함수 작성하고 싶은것 작성 
	 */
}
