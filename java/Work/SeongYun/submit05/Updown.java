package SeongYun.submit05;

import java.util.Scanner;

public class Updown {

	public static void main(String[] args) {
		// 랜덤한 수 얻기
		System.out.println(Math.random());

		// Math.random() 은 0~1 사이의 랜덤 실수를 리턴
		// Math.random() * 10은 0~10 사이의 랜덤 실수를 리턴
		// (int)(Math.random() *10)은 0~9 중 랜덤 정수를 리턴

		// 1부터 50까지 중 랜덤한 정수를 얻고싶다.
		// (int) (Math.random() * 50) + 1
		int randInt = (int) (Math.random() * 50) + 1;
		System.out.println(randInt);

		Scanner sc = new Scanner(System.in);

		for (int i = 5; i > 0; i--) {
			System.out.print("숫자를 입력해주세요: ");
			int num = Integer.parseInt(sc.nextLine());
			if (num == randInt) {
				System.out.println("정답입니다.");
				break;
			} else if (i == 1) {
				System.out.println("실패입니다. 정답은: " + randInt + "입니다.");
				break;
			}

			if (num < randInt) {
				System.out.println("업!! 기회가 " + (i - 1) + "번 남았습니다");
			} else if (num > randInt) {
				System.out.println("다운!! 기회가 " + (i - 1) + "번 남았습니다");
			}
		}

		

	}

}
