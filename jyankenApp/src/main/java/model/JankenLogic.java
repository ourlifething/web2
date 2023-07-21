package model;

import java.util.Random;

public class JankenLogic {
	public void execute(Janken janken) {
		Random rand = new Random();
		int idx = rand.nextInt(3);
		String[] hands = {"グー","チョキ","パー"};
		String pcHand = hands[idx];
		janken.setPcHand(pcHand);
		String result;
		if(pcHand.equals(janken.getUserHand())) {
			result = "draw";
		}else {
			result = "youwin";
		}
		janken.setResult(result);	
	}
}
