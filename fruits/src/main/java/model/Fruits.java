package model;

public class Fruits {
	private String name;
	private String area;
	private int price;
	//ソースー＞フィールドを使用してコンストラクターを生成
	public Fruits(String name, String area, int price) {
		super();
		this.name = name;
		this.area = area;
		this.price = price;
	}
	//ソースー＞setterおよびgetterを生成
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
