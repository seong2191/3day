package SeongYun.submit03;

import java.util.Scanner;
public class workThird {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		// 국어, 수학, 영어 점수를 입력하고
		// 등급을 출력하라
		System.out.println("국어 점수를 입력해주세요.");
		System.out.print(">>> ");
		int kuk = Integer.parseInt(scanner.nextLine());
		System.out.println("영어 점수를 입력해주세요.");
		System.out.print(">>> ");
		int eng = Integer.parseInt(scanner.nextLine());
		System.out.println("수학 점수를 입력해주세요.");
		System.out.print(">>> ");
		int mat = Integer.parseInt(scanner.nextLine());
		
		double avg = (kuk+eng+mat)/3.0;
		System.out.println("평균 :" + avg);
		
		// 점수값(실수) 반올림 하기
		long avgRes = Math.round(avg);
		System.out.println("반올림한 평균 :"+avgRes);
		
		String  grade = "";
		if(avg >= 90) {
			grade = "A";
		}else if(avg >= 80) {
			grade = "B";
			}else if(avg >= 70) {
				grade = "C";
			}else
				grade = "D";
		
		System.out.println("등급: "+grade);
		
		
		System.out.println("\n=========================================\n");
		
		//10! (10 팩토리얼) 값을 구하라
		
		int answer = 1;
		
		for(int i = 10; i > 0; i--) {
			answer = i*(answer);
			
			
		}
		System.out.println("결과: " + answer);
		
		long answer1 = 1; // int는 담을 수 없어서 long을 사용
		for(int i = 15; i >0; i--) {
			answer1 = i*answer1;
		}
		System.out.println("결과: "+ answer1);
		
		/* 10!
		 *int facTen = 1;
		 *for(int i = 1; i<= 10; i++){
		 *factTen *= i;
		 *} syso(factTen)
		 */
		
		/*
		 * 15!
		 * int facResult = 1;
		 * for(int i = 1; i <= 15; i++){
		 * facResult *= i;
		 * }syso(facResult)
		 * */
		
		
		System.out.println("\n=========================================\n");
		
		String findWally = "윌리울리일리울리울리일리월리일리윌리월리울리일리일리월리일리윌리일리윌리일리월리월리윌리울리윌리울리일리울리울리윌리일리";
		
		int count = 0;
				
		for(int i =0; i< findWally.length()-1; i++) {
			
			String str = findWally.substring(i,i+2);
			if(str.equals("월리")) {
				count++;
			}
			
		}
		System.out.println("결과: " + count);
		
		/*
		 * int countWally = 0;
		 * String findWally = ("월리윌리~~~")
		 * for(int i = 0; i <findWally.length(); i++){
		 * String twoWord = findWally.substring(i,i+2);
		 * if(twoWord.equals("월리")){
		 * coungWally++;}
		 * syso(countWally) 까지 하면 오류가 발생, substring의 함수 길이가 벗어났다.
		 * 
		 * 콘솔창에 결과값으로 값을봤는데 59번에서 오류가났다 스트링의 길이는 총 60이기에 길이에 -1로 해준다.
		 * */
		
		System.out.println("\n=========================================\n");
		
		
		
		for(int i = 5; i > 0; i--) {
			for(int j = i; j>0; j--) {
				System.out.print("*");
			}
			System.out.println("");
		}
		// 거꾸로트리
		
		/* String star = "*****"
		 * for(int i = 0; i <5; i++){
		 * syso(star.substring(i))
		 * }
		 * */
		
		
		String star = "*****";

		for(int i = 5; i >0; i--) {
			System.out.println(star.substring(5-i));
		}
		
		}
		
	}


