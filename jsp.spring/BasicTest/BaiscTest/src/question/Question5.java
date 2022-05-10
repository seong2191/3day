package question;

import java.util.Scanner;

public class Question5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int x = 0;
		int factorial = 1;
		
		System.out.println("정수 입력");
		System.out.println(">>> ");
		x = Integer.parseInt(sc.nextLine());
		
		for(int i = x; i >= 1; i--) {
			factorial = factorial *i;
		}
		System.out.println(x + "!은" + factorial);
		
	}
	
	
}
