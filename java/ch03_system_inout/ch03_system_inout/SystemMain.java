	package ch03_system_inout;

import java.util.Scanner;

public class SystemMain {
	
		public static void main(String[] args) {
		
		//표준 출력
		
		
		//shift+tab (칸 줄여주기)
		//tab (칸 넣기)
		// 행 선택은 커서위치에 따라 (shift+home, shift+end)
		
		//자동 줄맞추기
		//단축키 [ctrl+shift+F]
		//(단, 현재 클래스에 에러가 없어야 동작)
		
		//콘솔에 텍스트 출력하기
		//println() 콘솔창에 출력 후 줄바꿈(개행문자)이 들어간다.
		System.out.println("이미 알고 있는데요?");
		System.out.println(); // 개행문자만 들어간다.(줄바꿈만 들어가서 공백)
		System.out.println("아 정말요?");
		
		// print() 괄호안 텍스트를 콘솔에 출력은 동일
		// 개행문자가 들어가지 않는다.
		System.out.print("프린트는 개행문자가 들어가지 않아 쌍따옴표로하고");
		System.out.print("줄바꿈이 일어나지 않는다");
		System.out.println("\n=================================================\n");
		
		
		
		
		//제어문자
		//문자열 내에 역슬래시(\)를 이용하여 특정 기능을 사용할 수 있다.
		
		// \t 탭
		System.out.println("밥\t밥\t밥");
		System.out.println("1\t2\t3");
		
		// \n 줄바꿈
		System.out.print("프린트로 줄바꾸려면\n");
		
		//기능을 가지는 문자(\,",')를 콘솔창에 출력하고 싶다면 앞에 역슬래쉬(\)를 붙인다.
		System.out.println("제어문자는 앞에 \\를 붙인다.");
		System.out.println("\"열심히 하자\"");
		
		//특수문자도 출력 가능하다.
		System.out.println("★");
		
		System.out.println("\n=================================================\n");
		
		
		//print f()은 포맷 문자열(format string)과 함께 사용한다.
		System.out.printf("%d일차 진행중. \n",3);
		System.out.printf("%d일차 진행중. 밥까지 %d타임 남았다.\n",3,2);
		System.out.printf("밥까지 %d타임 남았다. %s먹어야하나.\n", 2,"뭘");
		
		
		//예시
		System.out.printf("%02d장 표준입출력\n",3); //%02d에서 2는 자릿수 맞춰주기
		System.out.printf("%.03f\n",3.141592); // 3자리까지 표현하라는 뜻. 4째자리에서 반올림된 값
		System.out.printf("%.04f\n",3.14); //자리수 표기이므로 부족한 자리는 0으로 채움 
		
		
		
		System.out.println("\n===============표준입력========================\n");
		
		//표준 입력
		Scanner scanner = new Scanner(System.in);
		System.out.println("이름을 입력해주세요");
		System.out.print(">>> ");
		String name = scanner.nextLine();
		System.out.println(name+": 더워");
		
		System.out.println("희망온도를 입력해주세요");
		System.out.print(">>> ");
		// scanner.nextInt()은 사용하지 마세요.
		//int temperature = scanner.nextInt();
		String temperature = scanner.nextLine();
		int temp = Integer.parseInt(temperature);
		
		System.out.println("희망온도: "+ (temp +1));
		
		System.out.println("냉방/난방 입력해주세요");
		System.out.print(">>> ");
		String airconMode = scanner.nextLine();
		System.out.println("모드: "+airconMode);
		
		
		// 키보드 입력을 받는 통로를 열어 두었던 것을 닫는다. (안닫아도 상관은 없다.)
//		scanner.close(); 
		
		//ctrl+마우스로 키워드 갖다대면 관련 키워드로 이동한다
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}
	
	}
