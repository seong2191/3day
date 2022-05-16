package ch10_extends_interface.starcraft;

public class Marine extends StarUnit {

	public Marine() {
		super("마린", 6, 50, 0, 4, 1, 2, 50, 0);
	}

	public void stimpack() {
		System.out.println("으아아아");
		// 스팀팩 쓰면 체력 10 감소
		super.setHp(super.getHp() - 10);

		// 스팀팩 쓰면 공격속도 두배
		super.setAttackSpeed(super.getAttackSpeed() * 2);
	}

}
