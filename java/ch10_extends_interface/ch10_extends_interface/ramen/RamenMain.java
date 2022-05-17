package ch10_extends_interface.ramen;

public class RamenMain {

	public static void main(String[] args) {

		HotRamen hot = new HotRamen("열라면", 1500, "빨간색라면.jpg");
		System.out.println(hot.name);
		hot.printRecipe();

		BuldakRamen buldak = new BuldakRamen();
		System.out.println(buldak.name);
		buldak.printRecipe();

	}

}
