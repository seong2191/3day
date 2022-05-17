package ch10_extends_interface.rpg;

import java.util.ArrayList;
import java.util.Scanner;

public class RpgMain {

	public static void main(String[] args) {
		Warrior dalhyun = new Warrior("달현", 100, 200, User.Jobs.WARRIOR_HANSON);
		Enemy chanung = new Enemy("찬웅", 10, 200);
		
		dalhyun.skill(chanung);
		
		Warrior hyensub = new Warrior("현섭", 100, 200, User.Jobs.WARRIOR_DUSON);
		Magicion nagyeom = new Magicion("나겸", 100, 200, User.Jobs.MAGIC_FIRE);
		Magicion syuli = new Magicion("설리", 100, 200, User.Jobs.MAGIC_ICE);
		
		Enemy devil = new Enemy("데블몬", 100, 1000);
		
		ArrayList<Character> battleGround = new ArrayList<>();
		
		battleGround.add(dalhyun);
		battleGround.add(hyensub);
		battleGround.add(nagyeom);
		battleGround.add(syuli);
		battleGround.add(devil);
		
		// 죽었을때, battleGround 리스트 내에서
		// 해당 객체가 제거되었으면..
		
		dalhyun.battle = new Battle() {
			@Override
			public void outOfBattle() {
				battleGround.remove(dalhyun);
			}
		};
		
		hyensub.battle = new Battle() {
			@Override
			public void outOfBattle() {
				battleGround.remove(hyensub);
			}
		};
		
		nagyeom.battle = new Battle() {
			@Override
			public void outOfBattle() {
				battleGround.remove(nagyeom);
			}
		};
		
		syuli.battle = new Battle() {
			@Override
			public void outOfBattle() {
				battleGround.remove(syuli);
			}
		};
		
		devil.battle = new Battle() {
			@Override
			public void outOfBattle() {
				battleGround.remove(devil);
			}
		};
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			for(int i = battleGround.size() -1; i >= 0; i--) {
				// 리스트 내 객체가 나(User)인 경우에만
				// 선택지 제공
				
				if(battleGround.get(i) instanceof User) {
					User turn = (User)battleGround.get(i);
					
					System.out.println(turn.getName() + "의 턴");
					System.out.println("1. 공격 | 2. 스킬");
					System.out.print(">>> ");
					
					int command = Integer.parseInt(sc.nextLine());
					
					if(command == 1) {
						turn.attack(devil);
					}else if(command == 2) {
						turn.skill(devil);
					}
					
				}
			}
			
			if(battleGround.contains(devil) == false) {
				System.out.println("승리");
				break;
			}
			
			if(battleGround.contains(dalhyun) == false 
					&& !battleGround.contains(nagyeom)
					&& !battleGround.contains(hyensub)
					&& !battleGround.contains(syuli)) {
				System.out.println("패배");
				break;
			}
			
			for(int i = 0; i < battleGround.size(); i++) {
				System.out.println(battleGround.get(i));
			}
			
		}
		
	}

}
