package question;

import java.util.Scanner;

public class Question4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("총 금액 입력");
		int price = Integer.parseInt(sc.nextLine());
		
		int[] arr = {500, 100, 50, 10};
		
		for(int i = 0; i < arr.length; i++) {
			if(price/arr[i] > 0) {
				System.out.println(arr[i] + "원 : " + price/arr[i]+ " 개 ");
				price%=arr[i];
			}
		}
		System.out.println();
	
	}
}
