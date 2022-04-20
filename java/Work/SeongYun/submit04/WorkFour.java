package SeongYun.submit04;

import java.util.Scanner;

public class WorkFour {

	public static void main(String[] args) {
		
		int rullet = 5834;
//		int one = rullet % 360; 
		String present = "";
		
		if((0 <= rullet % 360) && (rullet % 360 < 60))   {
			present = "사탕";
		}else if (( 60 <= rullet % 360) && (rullet % 360 < 120)) {
			present = "초콜릿";
		}else if (( 120 <= rullet % 360) && (rullet % 360 < 180)) {
			present = "쿠키";
		}else if (( 180 <= rullet % 360) && (rullet % 360 < 240)) {
			present = "콜라";
		}else if ((240 <= rullet % 360) && (rullet % 360 < 300)) {
			present = "아이스크림";
		}else {
			present = " 커피";
			}
		System.out.println(present);
		
		System.out.println(rullet / 360);
		
		
		
		
		
		System.out.println("\n=========================================\n");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("거꾸로 뒤집을 문자열 입력");
		System.out.print(": ");
		String rev = scanner.nextLine();
		
		//charAt
		// 로꾸꺼 로꾸꺼의 길이는 7인데
		// 인덱스는 0부터 시작이라 7을 벗어났다고 오류가 나옴. length-1
		for(int i = rev.length()-1; i>=0; i--) {
			System.out.print(rev.charAt(i));
		}
		
		//substring 이용
		String revStr = "";
		for(int i = rev.length()-1; i>=0;i--) {
			revStr += rev.substring(i,i+1);
			System.out.println(revStr);
		}
		
		
		
		
		System.out.println("\n=========================================\n");
		
		// 크리스마스 트리
		//    *
		//   ***
		//  *****
		// *******
		//*********
		
		// for문이 1,2,3,4,5번 실행
		// *은 1, 3, 5, 7, 9개
		// " "은 4, 3, 2, 1, 0개
		
		
		for(int i = 1; i<=5; i++) {
			for(int j = 5-i;j>0;j--) {
				System.out.print(" ");
			}
			for(int k=1; k<=i*2-1; k++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		// 풀
		String star = "*";
		for(int i = 0; i< 5; i++) {
			String blank = "";
			for(int j = 0; j < 4-i; j++) {
				blank += " ";
			}
			System.out.println(blank + star);
			star += "**";
		}
		
		System.out.println("\n=========================================\n");
		
		// 거꾸로 크리스마스 트리
		// *********
		//  *******
		//   *****
		//    ***
		//     *
		
		// for문이 1,2,3,4,5번 반복
		// *은 9,7,5,3,1
		// " "은 0,1,2,3,4
		for(int i = 5; i>=1; i--) {
			for(int j = 5-i;j>0;j--) {
				System.out.print(" ");
			}
			for(int k=1; k<=i*2-1; k++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		// 풀이
		String blank = "";
		for(int i = 0; i < 5; i++) {
			star = "*"; // 스타초기화
			for(int j = 0; j <4-i;j++) {
				star += "**";
			}
			
			System.out.println(blank + star);
			blank += " ";
		}
		
		
		
	}

}
