package ch09_class.worldcup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WorldCupMain {

	public static void main(String[] args) {
		// 이상형 월드컵
		ArrayList<Menu> menuList = new ArrayList<>();
		
		menuList.add(new Menu("짜장면"));
		menuList.add(new Menu("짬뽕"));
		menuList.add(new Menu("볶음밥"));
		menuList.add(new Menu("김치찌개"));
		menuList.add(new Menu("제육볶음"));
		menuList.add(new Menu("돈까스"));
		menuList.add(new Menu("카레"));
		menuList.add(new Menu("김밥/라면"));
		menuList.add(new Menu("순대국밥"));
		menuList.add(new Menu("냉면"));
		menuList.add(new Menu("삼겹살"));
		menuList.add(new Menu("생선구이"));
		menuList.add(new Menu("햄버거"));
		menuList.add(new Menu("떡볶이"));
		menuList.add(new Menu("소고기국밥"));
		menuList.add(new Menu("시래기"));
		
		// 재귀함수 만세
		playWorldCup(menuList);
		
		Scanner sc = new Scanner(System.in);
		
		// 16강
		// 0:1, 2:3, 4:5 ...
		System.out.println("16강");
		for(int i = 0; i < menuList.size(); i += 2) {
			System.out.println("메뉴를 선택해주세요");
			System.out.println("1. " + menuList.get(i).getName()
					+ " | 2. " + menuList.get(i+1).getName());
			System.out.print(">>> ");
			
			int command = Integer.parseInt(sc.nextLine());
			
			if(command == 1) {
				menuList.get(i).setSelect(true);
			}else if(command == 2) {
				menuList.get(i+1).setSelect(true);
			}
		}
		
		// 16강이 끝나고, menuList에서 true인 Menu들만
		// 8강으로 진출
		ArrayList<Menu> selectList = new ArrayList<>();
		for(int i = 0; i < menuList.size(); i++) {
			if(menuList.get(i).isSelect()) {
				selectList.add(menuList.get(i));
			}
		}
		
		for(int i = 0; i < selectList.size(); i++) {
			selectList.get(i).setSelect(false);
		}
		
		// 8강
		System.out.println("8강");
		for(int i = 0; i < selectList.size(); i += 2) {
			System.out.println("메뉴를 선택해주세요");
			System.out.println("1. " + selectList.get(i).getName()
					+ " | 2. " + selectList.get(i+1).getName());
			System.out.print(">>> ");
			
			int command = Integer.parseInt(sc.nextLine());
			
			if(command == 1) {
				selectList.get(i).setSelect(true);
			}else if(command == 2) {
				selectList.get(i+1).setSelect(true);
			}
		}
		
		// 8강이 끝나고, menuList에서 true인 Menu들만
		// 4강으로 진출
		ArrayList<Menu> selectList4 = new ArrayList<>();
		for(int i = 0; i < selectList.size(); i++) {
			if(selectList.get(i).isSelect()) {
				selectList4.add(selectList.get(i));
			}
		}
		
		for(int i = 0; i < selectList4.size(); i++) {
			selectList4.get(i).setSelect(false);
		}
		
		
		// 4강
		System.out.println("4강");
		for(int i = 0; i < selectList4.size(); i += 2) {
			System.out.println("메뉴를 선택해주세요");
			System.out.println("1. " + selectList4.get(i).getName()
					+ " | 2. " + selectList4.get(i+1).getName());
			System.out.print(">>> ");
			
			int command = Integer.parseInt(sc.nextLine());
			
			if(command == 1) {
				selectList4.get(i).setSelect(true);
			}else if(command == 2) {
				selectList4.get(i+1).setSelect(true);
			}
		}
		
		// 4강이 끝나고, menuList에서 true인 Menu들만
		// 2강으로 진출
		ArrayList<Menu> selectList2 = new ArrayList<>();
		for(int i = 0; i < selectList4.size(); i++) {
			if(selectList4.get(i).isSelect()) {
				selectList2.add(selectList4.get(i));
			}
		}
		
		for(int i = 0; i < selectList2.size(); i++) {
			selectList2.get(i).setSelect(false);
		}
		
		
		// 결승
		System.out.println("결승");
		for(int i = 0; i < selectList2.size(); i += 2) {
			System.out.println("메뉴를 선택해주세요");
			System.out.println("1. " + selectList2.get(i).getName()
					+ " | 2. " + selectList2.get(i+1).getName());
			System.out.print(">>> ");
			
			int command = Integer.parseInt(sc.nextLine());
			
			if(command == 1) {
				selectList2.get(i).setSelect(true);
			}else if(command == 2) {
				selectList2.get(i+1).setSelect(true);
			}
		}
		
		// 4강이 끝나고, menuList에서 true인 Menu들만
		// 2강으로 진출
		ArrayList<Menu> selectList1 = new ArrayList<>();
		for(int i = 0; i < selectList2.size(); i++) {
			if(selectList2.get(i).isSelect()) {
				selectList1.add(selectList2.get(i));
			}
		}
		
		System.out.println(selectList1.get(0).getName() + " 우승!!");
		
		
	} // main 끝
	
	static void playWorldCup(ArrayList<Menu> menuList) {
		Scanner sc = new Scanner(System.in);
		// 리스트 내부 순서 섞기
		Collections.shuffle(menuList);
		
		// 16강
		// 0:1, 2:3, 4:5 ...
		if(menuList.size() == 2) {
			System.out.println("결승");
		}else {
			System.out.println(menuList.size() + "강");
		}
		
		for(int i = 0; i < menuList.size(); i += 2) {
			System.out.println("메뉴를 선택해주세요");
			System.out.println("1. " + menuList.get(i).getName()
					+ " | 2. " + menuList.get(i+1).getName());
			System.out.print(">>> ");
			
			int command = Integer.parseInt(sc.nextLine());
			
			if(command == 1) {
				menuList.get(i).setSelect(true);
			}else if(command == 2) {
				menuList.get(i+1).setSelect(true);
			}
		}
		
		// 16강이 끝나고, menuList에서 true인 Menu들만
		// 8강으로 진출
		ArrayList<Menu> selectList = new ArrayList<>();
		for(int i = 0; i < menuList.size(); i++) {
			if(menuList.get(i).isSelect()) {
				selectList.add(menuList.get(i));
			}
		}
		
		for(int i = 0; i < selectList.size(); i++) {
			selectList.get(i).setSelect(false);
		}
		
		// 재귀함수
		if(selectList.size() == 1) {
			System.out.println(selectList.get(0).getName() + " 우승!!");
		}else {
			playWorldCup(selectList);
		}
		
	}
	
	
	
	

}