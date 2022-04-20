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

		// TODO 사용자의 위치를 입력받고 사용자의 위치와
		// 각 엘리베이터의 층수 차이를 계산
		// 해당 층수 차이에 따른 엘리베이터 이동
		// (층수 차이가 적은게 이동, 층수 차이가 같다면,
		// 높은 층에 있는 엘리베이터가 이동)

		int eleA = 10; // 엘리베이터 A의 위치
		int eleB = 4; // 엘리베이터 B의 위치
		String preEle = "";
		while (true) {
			System.out.println("\n=============희영빌딩 엘리베이터==========\n");
			System.out.println("승강기 A의 현재 위치: " + eleA + "층");
			System.out.println("승강기 B의 현재 위치: " + eleB + "층");

			System.out.print("몇층에 계시나요?[종료하시려면 q 또는 exit 입력]: ");
			String floor = sc.nextLine();

			if (floor.equalsIgnoreCase("q") || floor.equalsIgnoreCase("exit")) {
				System.out.print("프로그램이 종료되었습니다.");
				break;
			} else {
				int floorInt = Integer.parseInt(floor);

				if (Math.abs(floorInt - eleA) < (Math.abs(floorInt - eleB))) { // a가 더 가까운 경우
					System.out.println(eleA + "층에서 엘리베이터를 호출합니다.");
					System.out.println("승강기 A가 " + floorInt + "층으로 이동하였습니다.");
					eleA = floorInt;
					preEle = "A";
				} else if (Math.abs(floorInt - eleA) > Math.abs(floorInt - eleB)) { // b가 더 가까운 경우
					System.out.println("승강기 B가 " + floorInt + "층으로 이동하였습니다.");
					eleB = floorInt;
					preEle = "B";
				} else {
					if (eleA > eleB) {
						System.out.println("승강기 A가 " + floorInt + "층으로 이동하였습니다.");
						eleA = floorInt;
						preEle = "A";
					} else {
						System.out.println("승강기 B가 " + floorInt + "층으로 이동하였습니다.");
						eleB = floorInt;
						preEle = "B";
					}
				}
				System.out.println("\n=============희영빌딩 엘리베이터==========\n");
				System.out.println("승강기 " + preEle + "가 도착하였습니다.");
				System.out.print("이동할 층을 입력해주세요: ");
				int mov = Integer.parseInt(sc.nextLine());
				System.out.println("승강기 " + preEle + "가 " + mov + "층으로 이동합니다.");
				if (preEle.equals("A")) {
					eleA = mov;
				} else {
					eleB = mov;
				}

			}
		}

	}

}
