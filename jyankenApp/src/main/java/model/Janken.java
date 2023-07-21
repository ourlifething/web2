package model;

import java.io.Serializable;

public class Janken implements Serializable {
	private String userHand;
	private String pcHand;
	private String result;
	public Janken() {}
	public Janken(String userHand) {
		this.userHand = userHand;
	}
	public String getUserHand() {
		return this.userHand;
	}

	public String getPcHand() {
		return pcHand;
	}
	public void setPcHand(String pcHand) {
		this.pcHand = pcHand;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public void setUserHand(String userHand) {
		this.userHand = userHand;
	}
	
}
