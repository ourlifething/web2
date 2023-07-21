package model;

import java.io.Serializable;

public class FruitsJB implements Serializable{
	private int id;
	private String name;
	private String month;
	
	public FruitsJB() {}
	public FruitsJB(int id, String name, String month) {
		this.id=id;
		this.name=name;
		this.month=month;
	}
	public FruitsJB(String name, String month) {
		this.name=name;
		this.month=month;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
}
