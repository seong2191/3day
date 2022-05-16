package ch10_extends_interface.simple;

public class SimpleMain {

	public static void main(String[] args) {
		
		Child me = new Child("김김", 3045);
		
		System.out.println(me.getName());
		System.out.println(me.getAge());
		
		me.sayHello();
		
		// 형변환 기능
		Parent baby = new Child("아기", 4);
		baby.sayHello();
		
		

	}

}
