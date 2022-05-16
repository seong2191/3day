package ch10_extends_interface.starcraft;

public class Zealot extends ProtossUnit {

	public Zealot() {
		super("질럿", 16, 100, 1, 1, 2, 1, 100, 0, 60);

	}
	
	public void attack(StarUnit enemy) {
		// 스타유닛 적의 hp를 질럿의 데미지 만큼 깎겠다.
		enemy.setHp(enemy.getHp() - getDamage());
	}

}
