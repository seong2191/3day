package ch05_control;

import java.util.Scanner;

public class LoopWhile {

	public static void main(String[] args) {
		//while 문 false가 될 때까지 무한 반복
		
		int i = 0; // 초기화식
		while(i < 10) {   // 조건식
			System.out.println(i);
			i++; // 증감식
		}
		
		// for문의 냄새가..
		// 구구단 2단 출력을 while문을 이용해서 출력
		// 2 x 2 = 4
		// 2 x 3 = 6
		// 2 x 9 = 18
		int j = 2;
		while(j <= 9) {
			System.out.println("2 x " + j +" = " + 2*j );
			j++;
		}
		
		i = 0; // i 초기화
		for( ;i <10 ; ) {
			System.out.println(i);
			i++;
		}
		// 못생긴 for문은 쓰지맙시다.
		
		System.out.println("\n==================================\n");
		
		boolean isRun = true;
		Scanner sc = new Scanner(System.in);
		
//		while(isRun) {
//			System.out.println("이름 입력 [종료하시려면 q 또는 Q 입력]");
//			System.out.print(">>> ");
//			
//			String inputText = sc.nextLine();
//			
//			if(inputText.equals("q")|| inputText.equals("Q")) {
//				System.out.println("프로그램을 종료합니다.");
//				isRun = false;
//			}else {
//				System.out.println(inputText + "님 환영합니다"); 	// 입력해도 끝나지 않는다.
//			}
//		}
		
		while(true) {
			System.out.println("이름 입력[종료하려면 q 또는 Q}");
			System.out.print(">>> ");
			
			String inputText = sc.nextLine();
			
			// inputText.toLowerCase().equals("q") 밑에 구문과 동일
			if(inputText.equalsIgnoreCase("q")) { // ignorecase 는 대소문자를 구별하지 않는다.
				System.out.println("프로그램 종료");
				break; // 순서 유의
			}
				System.out.println(inputText + "님 환영합니다.");
		}
		
		System.out.println("\n==================================\n");
		isRun = false; // isRun값 초기화
		
		
		do {
			System.out.println("이름 입력[종료하려면 q 또는 Q}");
			System.out.print(">>> ");
			
			String inputText = sc.nextLine();
			
			// inputText.toLowerCase().equals("q") 밑에 구문과 동일
			if(inputText.equalsIgnoreCase("q")) { // ignorecase 는 대소문자를 구별하지 않는다.
				System.out.println("프로그램 종료");
				break; // 순서 유의
			}
				System.out.println(inputText + "님 환영합니다.");
		}while(isRun);
		
		
		System.out.println("\n==================================\n");
		
		// while문 또한 다중으로 사용가능
		// 구구단
		// 2 x 2 = 4
		// 2 x 3 = 6
		// 3 x 2 = 6
		// 3 x 3 = 9
		// 9 x 9 = 81
		int left = 2;
		
		while(left <= 9) {
			int right = 2;
			while(right <=9) {
				System.out.println(left + " x " + right + " = " + (left*right));
				right++;
			}
			left++;
		}
		
		// 포켓몬스터
		int enemyHp = 100;
		outer: while(true) {
			System.out.println("야생의 파이리를 만났습니다.");
			System.out.println("행동을 선택해주세요.");
			System.out.println("1. 공격 | 2. 도망");
			System.out.print(">>> ");
			
			int command = Integer.parseInt(sc.nextLine());
			
			if(command == 1) {
				while(true) {
					System.out.println("공격 방법 선택");
					System.out.println("1. 백만볼트 | 2. 전광석화 | 3. 취소");
					System.out.print(">>> ");
					
					int attack = Integer.parseInt(sc.nextLine());
					
					if(attack == 1) {
						System.out.println("피카츄 백만볼트");
						enemyHp -= 20;
					}else if(attack == 2) {
						System.out.println("피카츄 전광석화");
						enemyHp -= 10;
					}else if(attack == 3) {
						// 내부 while문 종료
						// 외부 while문은 계속 실행
						break;
					}
					
					// 파이리 사망
					if(enemyHp <=0) {
						System.out.println("파이리를 잡았다");
//						System.exit(0); 이런게 있구나
						break outer;
					}
				}
			}else if(command == 2) {
				System.out.println("도망쳤습니다.");
				break;
			}
		}
		
		
		
	}

}
