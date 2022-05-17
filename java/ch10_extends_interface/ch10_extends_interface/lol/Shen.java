package ch10_extends_interface.lol;

// 인터페이스를 구현(implement)하기 위해서는
// extends가 아닌 implements를 사용한다.
public class Shen extends Champion implements Lolinterface, Voiceinterface{

	public Shen(String name, int damage, int hp) {
		super(name, damage, hp);
	}

	@Override
	public void skillQ() {
		System.out.println("3대");
	}

	@Override
	public void skillW() {
		System.out.println("장판");
	}

	@Override
	public void skillE() {
		System.out.println("도발");
	}

	@Override
	public void skillR() {
		System.out.println("쉴드");
	}

	@Override
	public void ctrl1() {
		System.out.println("춤");
	}

	@Override
	public void ctrl2() {
		System.out.println("넌 이미 죽어있다.");
	}

	@Override
	public void ctrl3() {
		System.out.println("슈슉슉3번");
	}

	@Override
	public void ctrl4() {
		System.out.println("웃음");
	}
	
	
	
	

}
