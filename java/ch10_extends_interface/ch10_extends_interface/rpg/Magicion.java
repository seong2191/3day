package ch10_extends_interface.rpg;

public class Magicion extends User{

	public Magicion(String name, int damage, int hp, Jobs job) {
		super(name, damage, hp, job);
	}

	@Override
	public void skill(Enemy enemy) {
		switch(job) {
			case MAGIC_FIRE:
				System.out.println("불 스킬 사용");
				enemy.setHp(enemy.getHp() - Constants.SKILL_FIRE);
				break;
				
			case MAGIC_ICE:
				System.out.println("얼음 스킬 사용");
				enemy.setHp(enemy.getHp() - Constants.SKILL_ICE);
				break;
		}
		
		System.out.println(enemy.getName() + " 체력: " 
				+ enemy.getHp());
		if(enemy.getHp() <= 0) {
			enemy.die();
		}
		
	}
	
	
	
	
	
	
	
}
