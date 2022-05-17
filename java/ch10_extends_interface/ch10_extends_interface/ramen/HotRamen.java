package ch10_extends_interface.ramen;

public class HotRamen extends Ramen {

	public HotRamen(String name, int price, String image) {
		super(name, price, image);
	}
	
	@Override
	public void printRecipe() {
		System.out.println("끓는 물에 면과 스프를 넣고, 3분 후에 저어서 드세요.");
	}

}
