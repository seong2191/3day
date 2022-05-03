package ch09_class;

// 유용한 함수들을 제공하는 클래스

public class UtilClass {
	
	/**
	 * 입력한 실수를 소수 n번째 자리로 리턴해주는 함수(method)
	 * 
	 * @param num 반올림하고자 하는 실수
	 * @param n   소수 n번째 자리까지 리턴
	 * @return 반올림된 실수 리턴
	 */
	public static double weRound(double num, int n) {
		// Math.round() 는 소수 첫째자리에서
		// 반올림한 정수를 리턴
		// 3.141592 에 Math.round(3.141592)
		// 를 하면 3이 리턴됨
		// 소수 첫째자리 = 10을 곱한 후 나눔(10^1)
		// 10을 곱한 31.41592 에 Math.round(31.41592)
		// 를 하면 31이 리턴됨, 이후 10으로 나누면 3.1이 리턴
		// 소수 둘째자리 = 100을 곱한 후 나눔(10^1)
		// 100을 곱한 314.1592 에 Math.round(314.1592)
		// 를 하면 314가 리턴되고 100으로 나누면 3.14가 리턴

		// one은 10의 n승
		int one = 1;
		for (int i = 0; i < n; i++) {
			one *= 10;
		}
		num *= one;
		long temp = Math.round(num);
		double result = (double) temp / one;

		return result;
	}

	static int absolute(int num) {
		if (num < 0) {
			num *= -1;
		}
		return num;
	}
	
	

}
