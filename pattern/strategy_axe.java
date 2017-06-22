package pattern;

public class strategy_axe implements strategy_weapon {
	@Override
	public void attack(){
		System.out.println("도끼로 자르다");
	}
}
