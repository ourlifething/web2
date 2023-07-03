package model; //パッケージ必要

import java.io.Serializable; //必要

public class Human implements Serializable { //Serializable 必要
	private String name;
	private int age;
	
	public Human() {}; //必ず引数なしのコンストラクタが必要、他は自由。
	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}

