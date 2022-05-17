package ch10_extends_interface.rpg;

public abstract class User extends Character {
	public Jobs job;

	public User(String name, int damage, int hp, Jobs job) {
		super(name, damage, hp);
		this.job = job;
	}
	
	public void attack(Enemy enemy) {
		System.out.println(enemy.getName() + "를 공격합니다.");
		enemy.setHp(enemy.getHp() - super.getDamage());
		System.out.println(super.getDamage() + "만큼 피해를 입힙니다.");
		
		super.setHp(super.getHp() - enemy.getDamage());
		System.out.println(enemy.getDamage() + "만큼 피해를 입었습니다.");
		
		System.out.println(super.getName() + "의 체력: " + super.getHp());
		System.out.println(enemy.getName() + "의 체력: " + enemy.getHp());
	
		if(enemy.getHp() <= 0) {
			// enemy 깨꼬닥
			enemy.die();
		}
		
		if(super.getHp() <= 0) {
			// 내가 깨꼬닥
			super.die();
		}
		
	}
	
	public abstract void skill(Enemy enemy);
	
	public enum Jobs {
		WARRIOR_HANSON,
		WARRIOR_DUSON,
		MAGIC_FIRE,
		MAGIC_ICE
	}
}
