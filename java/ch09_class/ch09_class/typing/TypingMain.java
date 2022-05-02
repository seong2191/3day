package ch09_class.typing;

import java.util.Scanner;

public class TypingMain {

	public static void main(String[] args) {
		// 타자 연습
		Dictionary dictionary = new Dictionary(); // 생성자
		
		System.out.println(dictionary.wordList);
		
		Scanner sc = new Scanner(System.in);
		
		// 1970년 1월 1일 기준으로 현재까지의 경과된 시간을 밀리초 단위로 리턴(1초 = 1000밀리초) 
		long pastTime = System.currentTimeMillis();
		System.out.println(pastTime);
		while(true) {
			dictionary.showWord();
			
			System.out.print(">>> ");
			String inputText = sc.nextLine();
			
			if(dictionary.typingCheck(inputText)) {
				dictionary.removeWord();
			}
			
			if(dictionary.getListSize() == 0) {
				break;
			}
		}
		
		long currentTime = System.currentTimeMillis();
		long diffTime = currentTime - pastTime;
		double result = diffTime / 1000.0;
		System.out.println(result + "초 걸리셨습니다");
		
		

	}

}
