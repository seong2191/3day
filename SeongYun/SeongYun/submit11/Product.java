package SeongYun.submit11;

public class Product {
	
	private String name; // private는 캡슐
	private int price;

	
	// 기본생성
	public Product(){
	
}
	//생성자
	public Product(String name, int price) {
	this.name = name;
	this.price = price;
	
}
	// Getters and Setters
	@Override
	public String toString() {
		return "제품명: " +  name + ", 가격: " + price +"원";
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	

}