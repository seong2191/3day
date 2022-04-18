package SeongYun.submit03;

import java.util.Scanner;
public class workThird {

	public static void main(String[] args) {
		/*
		Scanner scanner = new Scanner(System.in);
		
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
		
		String  grade = "";
		if(avg > 80) {
			grade = "B";
		}
		System.out.println("등급: "+grade);
		*/
		
		System.out.println("\n=========================================\n");
		
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
		
		
		System.out.println("\n=========================================\n");
		
		
		
		for(int i = 5; i > 0; i--) {
			for(int j = i; j>0; j--) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		
		
		}
		
	}


