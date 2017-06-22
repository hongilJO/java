package pattern;

public class strategy_sword implements strategy_weapon {

	@Override
	public void attack(){
		System.out.println("검으로 타격하다.");
	}
}
