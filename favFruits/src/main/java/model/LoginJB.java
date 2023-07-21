package model;

import java.io.Serializable;

public class LoginJB implements Serializable{
	private String name;
	private String pass;
	public LoginJB() {}
	public LoginJB(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	
}
