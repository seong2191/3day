package ch10_extends_interface.ramen;

// 추상 메소드를 하나 이상 포함한다면 무조건 추상클래스로 선언해야 한다.
public abstract class Ramen {

	String name;
	int price;
	String image;

	public Ramen(String name, int price, String image) {
		super();
		this.name = name;
		this.price = price;
		this.image = image;
	}

	// 라면의 레시피를 출력해주는 함수
	// 라면마다 레시피가 다르기 때문에 추상(abstract)메소드로 만든다.
	public abstract void printRecipe();

}