package ch11_java_api;

import java.util.Random;

public class ApiMath {

	public static void main(String[] args) {
		final double PI = 3.141592;

		// 반올림
		long roundPI = Math.round(PI);
		System.out.println(roundPI);

		// 소수 넷째자리에서 반올림하여 3.142 만들기
		double fourPI = (Math.round(PI * 1000)) / 1000.0;
		System.out.println(fourPI);

		// 올림(ceil)
		double ceilPI = Math.ceil(PI);
		System.out.println(ceilPI);

		// 내림(floor)
		double floorPI = Math.floor(PI);
		System.out.println(floorPI);

		// 절댓값
		int minus = -10;
		int absVal = Math.abs(minus);
		System.out.println(absVal);

		// 로직으로 절댓값 구하기
		if (minus < 0) {
			absVal = minus * -1;
		} else {
			absVal = minus;
		}
		System.out.println(absVal);

		// 제곱
		// 3의 3제곱
		double powVal = Math.pow(3, 3);
		System.out.println(powVal);

		// 로직으로 제곱 구현
		// 3의 4제곱
		int result = 1;
		for (int i = 0; i < 4; i++) {
			result *= 3;
		}
		System.out.println(result);

		// 제곱근(루트)
		int anyNum = 144;
		double sqrtVal = Math.sqrt(anyNum);
		System.out.println(sqrtVal);

		// 랜덤 숫자(난수)생성
		// 0부터 1사이 [0을ㄹ 포함, 1은 포함하지 않음]
		// 랜덤 실수 리턴
		double randNum = Math.random();
		System.out.println(randNum);

		// 로또 번호[1~45 랜덤 숫자]
		int randInt = (int) (Math.random() * 45) + 1;
		System.out.println(randInt);

		// 10부터 20까지의 랜덤 숫자
		randInt = (int) (Math.random() * 11) + 10;
		System.out.println(randInt);

		// a부터 b까지의 랜덤 숫자
		int a = 10;
		int b = 20;
		randInt = (int) (Math.random() * (b - a + 1)) + a;

		System.out.println("\n===========================================\n");

		// 랜덤은 따로 Random 클래스 존재
		// 따로 객체를 생성해야 하는 불편함이 있다.

		Random random = new Random();

		randInt = random.nextInt();
		System.out.println(randInt);

		// .nextInt(n)
		// 0부터 n-1까지 중 랜덤한 정수 리턴
		randInt = random.nextInt(10); // 0~9
		System.out.println(randInt);

		// 10~20까지의 랜덤 정수
		randInt = random.nextInt(11) + 10; // 11~20
		System.out.println(randInt);

		// 랜덤실수
		System.out.println(random.nextDouble());

		// 랜덤 true / false
		System.out.println(random.nextBoolean());

		// 10% 확률로 당첨
		randInt = random.nextInt(100) + 1;
		System.out.println(randInt);
		// randInt = 1부터 100사이 숫자
		if (randInt <= 10) {
			System.out.println("당첨!! [10%]");
		} else {
			System.out.println("꽝!! [10%]");
		}

		// 35% 확률로 당첨
		if (randInt <= 35) {
			System.out.println("당첨!! [35%]");
		} else {
			System.out.println("꽝!! [35%]");
		}

		// 85% 확률로 당첨
		if (randInt <= 85) {
			System.out.println("당첨!! [85%]");
		} else {
			System.out.println("꽝!! [85%]");
		}

		System.out.println("\n===========================================\n");

		// 시드 설정
		// 시드는 랜덤 난수를 생성할때 내부적으로 사용되는 값
		random.setSeed(7);
		for (int i = 0; i < 6; i++) {
			System.out.println(random.nextInt(45) + 1);
		}

	}

}
