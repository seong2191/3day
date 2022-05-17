package ch10_extends_interface.rpg;

public class Warrior extends User {
	
	public Warrior(String name, int damage, int hp, Jobs job) {
		super(name, damage, hp, job);
	}
	
	@Override
	public void skill(Enemy enemy) {
		// 스킬 메소드 실행시 직업마다
		// 다른 스킬이 시전되도록
		
		switch(job) {
			case WARRIOR_HANSON:
				System.out.println("한손검 스킬 사용");
				enemy.setHp(enemy.getHp() - Constants.SKILL_HANSON);
				break;
			
			case WARRIOR_DUSON:
				System.out.println("두손검 스킬 사용");
				enemy.setHp(enemy.getHp() - Constants.SKILL_DUSON);
				break;
				
		}
		
		System.out.println(enemy.getName() + " 체력: " 
								+ enemy.getHp());
		if(enemy.getHp() <= 0) {
			enemy.die();
		}
		
	}
	
	

	@Override
	public String toString() {
		return "Warrior [name=" + getName() + ", damage=" 
				+ getDamage() + ", hp=" + super.getHp() + "]";
	}

}
