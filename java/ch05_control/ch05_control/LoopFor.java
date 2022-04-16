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
		
		// 1부터 20까지 더하기
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
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			
		}
		
		
		

	}

}
