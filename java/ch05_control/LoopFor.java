package ch05_control;

public class LoopFor {

	public static void main(String[] args) {
		
		// 반복문
		// for문
		
		// 변수를 한번쓰면 남아있지 않음
		// 콘솔창에 1부터 10까지 출력
		for(int i = 1; i<=10; i++) {
			System.out.println(i);
		}
		
		// 콘솔창에 0~9 중 2씩 증가시킴
		for(int i = 0; i < 10; i +=2) {
			System.out.println(i);
		}
		
		System.out.println("\n====================================\n");
		
		// 1부터 20까지 더하기e
		int addResult = 0;
		for(int i = 1; i <=20; i++) {
			addResult += i;
		}
		System.out.println(addResult);
		
		
		// 21부터 45까지 더하기
		int addResult1 = 0;
		for(int i = 21; i <=45; i++) {
			addResult1 += i;
		}
		System.out.println(addResult1);
		
		
		System.out.println("\n====================================\n");
		
		for(double i = 0; i<2; i+=0.2) {
			System.out.println(i);
			//실수인 float과 double의 연산은
			//정확하지 않으므로 비추천
		}
		
		
		for(int i = 0; i <= 20; i += 2) {
			System.out.println(i/10.0);
		}
		
		System.out.println("\n====================================\n");
		
		// 구구단 2단
		// 2 x 1 = 2
		// 2 x 2 = 4
		// 2 x 9 = 18
		
		for(int i = 1; i < 10; i++) {
			System.out.println("2 x "+ i + " = "+(i*2));
		}
		
		System.out.println("\n====================================\n");
		
		
		/* 디버깅 모드
		 * 코드라인 좌측 부분을 더블클릭하여
		 * breakpoint(초록색 점)를 만든 후 실행
		 * [단축키 Ctrl + Shift + B]
		 * 토글형식이라 더블클릭 혹은 단축키로
		 * 생성/삭제 가능
		 * 
		 * 디버깅 목적
		 * 코드를 한줄한줄 실행해보며 변수에 어떤 값이
		 * 담기고 있는지 확인할때 사용
		 * 
		 *  디버깅 실행
		 *  상단 벌레모양의 아이콘 클릭[단축키 F11]
		 *  창이 하나뜨면 디버깅 모드에 적합한 화면(perspective) 전환 여부
		 *  코드들이 위에서부터 실행되다가 breakpoint가 있는 지점에
		 *  멈춰서 대기를 한다.
		 *  
		 *  
		 *  이후 상단의 RUN - step over [ 단축키 F6 ]
		 *  를 실행하면 한줄한줄 실행이 됩니다.
		 *  
		 *  디버깅 모드를 종료하려면 Terminate[단축키 Ctrl + F2]
		 *  
		 *  이후 원래 화면(perspective)으로 돌아오려면
		 *  우측 상단 JAVA perspective 클릭
		 *  
		 *  
		 */
		
		System.out.println("\n====================================\n");
		
		// 1부터 10까지 홀수만 출력
		for(int i = 1; i<10; i++ ) {
			if(i%2 ==1) {
			System.out.println(i);
		}
		} // 10번 실행
		
		for(int i = 1; i<10; i +=2 ) {
			System.out.println(i);
		}// 5번 실행(성능 증가 = 프로그램 실행 속도 증가
		
		System.out.println("\n====================================\n");
		
		
		//아래의 5층 트리를 for문을 사용하여 만들어주세요
		String star = "";
		
		for(int i = 1; i<6; i++) {
			star += "*";	
			System.out.println(star);
		}
		/*System.out.println("*");
		System.out.println("**");
		System.out.println("***");
		System.out.println("****");
		System.out.println("*****");
		*/
		
		// % 나머지 연산 주로 사용 예시
		// for문 내에서 순환하는 숫자에 대해 사용
		
		// 국수공장에서 면을 20cm 뽑고 있는데,
		// 5cm마다 잘라주기
		
		for(int i= 0; i<20; i++) {
			System.out.println("||||||||");
			
			// i가 4일때 면이 5cm가 되서 잘라야함
			// i가 9일때, 14일때 잘라야함
			// || <= or(또는)
			if((i == 4) ||(i ==9) || (i==14)) {
				System.out.println("--------");
			}
		}
			
			System.out.println("\n================안 성 탕 면===================\n");
			
			// 라면 공장에서 면을 30cm 뽑고 있는데
			// 6cm 마다 잘라주어야 한다.
			
			
		for(int i = 0; i <30; i++) {
			if(i % 2 == 1) {
				System.out.println("////////");
			}else {
				System.out.println("\\\\\\\\\\\\\\\\");
			}
		
			
			// i가 5면 6cm가 되서 잘라야함
			// i가 11,17,23 일대 잘라야함 //규칙은 6으로 나눈 나머지가 5
			if(i % 6 == 5) {
				System.out.println("--------");
			}
			
			
//			try {
//				Thread.sleep(300);
//				// 현재 코드를 실행중인 Thread를
//				// 괄호 안 시간(단위 : 밀리초, ms)
//				// 만큼 잠깐 재웠다가 깨어납니다.
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			
			}
		
		System.out.println("\n====================================\n");
			
			
			
		// 지금으로부터 100시간 후 몇일 몇시가 될까?
		int currentDay = 18;
		int currentHour = 9;
		
		for(int i = 0; i< 100; i++) {
		int day = currentDay + (currentHour/24);
		int hour = currentHour % 24;
		System.out.println(day +" 일 "+ hour + " 시 ");
		currentHour++;
		}
		
		System.out.println("\n====================================\n");
		
		// 거꾸로 for문
		// 10부터 1까지 출력
		int num = 10;
		for(int i= 0; i <10; i++) {
			System.out.println(num--);
//			num--; //이걸 빼고 프린트에 --를 붙였다
		}
		
		for(int i = 10; i >=1; i--) {
			System.out.println(i);
		}
		
		System.out.println("\n====================================\n");
		
		// 거꾸로 구구단 2단을 출력
		// 2 x 9 = 18
		// 2 x 8 = 16
		// 2 x 2 = 4
		
		for(int i = 9; i > 1; i--) {
			System.out.println("2 x " + i + " = " + (i*2));
		}
		
		
		System.out.println("\n====================================\n");
		
		// for문으로 String 문자열을 가지고 놀기
		
		// for문을 이용해서 숫자 문자열의
		// 각 자릿수를 더해서 결과를 출력
		
		String example = "213124235132143";
		int result = 0;
		
		for(int i = 0; i < example.length(); i++) {
//			String str = example.substring(i,i+1);
//			int exaInt = Integer.parseInt(str);
//			result += exaInt;
			
			result += Integer.parseInt(example.substring(i,i+1));
			
			System.out.println("각 자리수를 더한 결과 = "+ result);
		}
			
			// 슈의 개수
			String shoot = "슈슈슛슈슈슈슛슈슛ㅅㅅ슈슛";
			
			// shoot 문자열의 길이만큼 반복하는 for문
			// 반복문이 실행될때마다 shoot을 한글자씩 자른다.
			// 자른 글자가 슛인지 판별(if)
			// 슛이라면 count를 1씩 올려준다.
			int count = 0;
			
			for(int i = 0; i> shoot.length(); i++) {
				String str = shoot.substring(i,i++);
				if(shoot.equals("슈")) {
					count++;}
				
				System.out.println("슈의 개수 : "+ count);
			}
			
			System.out.println("\n=========================================\n");
			
			// break 문
			// i가 1부터 10까지 증가하는 for문에서
			// i가 5보다 커지게 되면 for문을 종료할래
			for(int i = 1; i<=10; i++) {
				
				if(i>5) {
					// 컴퓨터가 break 명령어를
					// 실행하면 가까운 반복문(for, while)을
					// 하나를 즉시 종료한다.
					break;
				}
				System.out.println(i);
				
			}
			
			//1부터 n까지 더한다고 했을때,
			//100 이상이 되는 n을 구할래
			int sum = 0;
			for(int i =1; i < 9999; i++) {
				sum += i;
				
				if(sum >= 100) {
					System.out.println("100이상이 되는 n은 " + i + "입니다.");
					break;
				}
			}
			
			System.out.println("\n=========================================\n");
			
			// continue 문
			
			//구구단 7단을 출력하는데,
			// 너무 쉬운 2,3,4 는 출력 안할래
			for(int i = 2; i<=9; i++) {
				if(i<5) {
					// 컴퓨터가 실행시
					// continue 아래 코드는 무시하고
					// 바로 다음 for문으로 진행한다.
					continue;
				}
				System.out.println("7 x "+ i + " = " + (7*i));
			}
			System.out.println("\n=========================================\n");
			
			// 다중 for문
			// 구구단을 출력
			// 2 x 2 = 4
			// 2 x 3 = 6
			// 2 x 9 = 18
			// 3 x 2 = 6
			// 3 x 3 = 9
			// 3 x 9 = 27
			// 9 x 9 = 81
			
			for(int i = 2 ; i <= 9; i++) {
				for(int j = 2; j <= 9; j++)
					System.out.println(i + " x "+j + " = " + i*j);
			}
			
			
			System.out.println("\n=========================================\n");
			// 트리
			//     *
			//    **
			//   ***
			//  ****
			// *****
			
			String blank = "     ";
			String starTree = "";
			for(int i = 0 ; i < 5; i++) {
				starTree += "*";
				System.out.println(blank.substring(i) + starTree);
				
			}
			
			// 이중 for문으로 트리 만들기~.~
			
			// 외부 for문이 한번 돌때,
			// * 은 1개, 내부 for문에 의해 " "은 5개
			// 외부 for문이 두번 돌때,
			// * 은 2개, 내부 for문에 의해 " "은 4개
			// 외부 for문이 세번 돌때,
			// * 은 3개, 내부 for문에 의해 " "은 3개
			
			starTree = "";
			
			
			for(int i = 0 ; i <5; i++) {
					starTree += "*";
					blank = "";
					for(int j = 0; j < 5 - i; j++) {
						blank += " ";
				}
					System.out.println(blank + starTree);
			}
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
	}


