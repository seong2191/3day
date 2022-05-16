package ch10_extends_interface.starcraft;

public class ProtossUnit extends StarUnit {
	// StarUnit -> ProtossUnit -> Zealot, HighTemplar, ...
	
	private int shield;

	public ProtossUnit(String name, int damage, int hp, int armor, int attackRange, int attackSpeed, int moveSpeed,
			int mineral, int gas, int shield) {
		super(name, damage, hp, armor, attackRange, attackSpeed, moveSpeed, mineral, gas);
		this.shield = shield;
	}

	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}
	
	
	

}
