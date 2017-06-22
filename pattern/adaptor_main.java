package pattern;

public class adaptor_main {
	
	/* adaptor란?
	 * 연관성 없는 두객체를 묶어 사용하기
	 * 예를 들어 220v 기본인 우리나라 가정집에서 110v를 사용하긴 위해선 adaptor를 사용한다. 
	 * 이처럼 adaptor_math라는 클래스에서 double형의 반환값을 하는 메소드가 있는데 이것들이 float형의 반환값을 리턴하도록 변경하고 싶다.
	 * adaptor_impl 이라는 기능을 정의하고 adaptor라는 기능을 구현하여 이를 활용하자. 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		adaptor ad = new adaptor();
		System.out.println(ad.multiply_two(20f));
		System.out.println(ad.multiply_half(30f));
	}

}
