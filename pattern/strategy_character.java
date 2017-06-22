package pattern;

public class strategy_character implements strategy_weapon {

	private strategy_weapon w1;
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		if(w1==null){
			System.out.println("맨손타격합니다.");
		}
		else{
			w1.attack();
		}
	}
    public void set_weapon(strategy_weapon w){
    	this.w1=w;
    }
}
