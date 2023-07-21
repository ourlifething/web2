package model;

import java.io.Serializable;

public class Mutter implements Serializable{
	private String userName; //ユーザー名
	private String text; // つぶやき内容
	
	public Mutter() {};
	public Mutter(String userName, String text) {
		this.userName = userName;
		this.text = text;
	}
	public String getUserName() {
		return this.userName;
	}
	public String getText() {
		return this.text;
	}
}
