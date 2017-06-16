package design_pattern;

import design_pattern_interface.dofly;
import design_pattern_interface.dontfly;
import design_pattern_interface.doshooting;

public class strategyPatternMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		strategyPattern s1 = new strategyPattern1();
		s1.setdofly(new dofly());
		s1.setdoshooting(new doshooting());
		
		strategyPattern s2 = new strategyPattern2();
		s2.setdofly(new dontfly());
		s2.setdoshooting(new doshooting());
		
		s1.actionfly();
		s1.actionshooting();
		s2.actionfly();
		s2.actionshooting();
	}

}
