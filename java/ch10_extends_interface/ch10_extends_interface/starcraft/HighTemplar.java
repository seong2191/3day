package ch10_extends_interface.starcraft;

public class HighTemplar extends ProtossUnit {
	// 필드 변수를 복붙했다 => 그 말은 중복코드
	// 중복코드를 한 곳에 묶어놓으면 편함 => 수정이 용이하다.

	private int mp;

	public HighTemplar() {

		super("하이템플러", 0, 40, 0, 0, 0, 1, 50, 150, 40);
		this.mp = 250;
	}

	public void skillStorm() {
		System.out.println("사이오닉 스톰");
		mp -= 75;
	}

	public void hallo() {
		System.out.println("할루시네이션");
		mp -= 100;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

}
