package ch10_extends_interface.simple;

// extends Parent 는 Parent 클래스를 상속받고있다 는 
public class Child extends Parent{
	
	public Child(String name, int age){
		// 슈퍼는 부모의 생성자를 의미
		super(name, age);
	}
	
	@Override
	public void sayHello() {
		System.out.println("응애응애"+ getName());
	}
	
	

}
