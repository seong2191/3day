package ch10_extends_interface.ramen;

public class BuldakRamen extends Ramen {

	public BuldakRamen() {
		super("불닭볶음면", 1500, "닭.jpg");
	}

	public void printRecipe() {
		System.out.println("끓는 물에 면을 넣어 끓인 후 건져서 액상스프를 넣고 슈웃");
	}

}
