package SeongYun.submit08;

import java.util.Arrays;

public class submit08 {

	public static void main(String[] args) {

		// 로또 번호 생성기
		// Array에 랜덤 숫자 1~45를 6개 넣어주는데 중복을 허용하지 않아야 함.
		// 출력 후에 오름차순으로 정렬

		int[] lottoArray = makeLotto();
		printArray(lottoArray);

		// lottoArray와 winLotto를 비교하여 전부다 일치하는 경우
		// 당첨되었다고 출력
		// 1개라도 틀리면 낙첨
		// 4월 26일 기준 지난주 1등 당첨번호
		int[] winLotto = { 5, 11, 18, 20, 35, 45 };
		
		int num = 0;
		while(true) {
			System.out.println(++num + "회 실행");
			if(lotto2(winLotto, makeLotto())) {
				System.out.println("1등");
				System.out.println("구매 횟수"+ num);
				System.out.println("구매 금액: " + (num*1000l) + "원");
				break;
			}
			
			
		}

		int count = 0;
		for (int i = 0; i < winLotto.length; i++) {
			if (winLotto[i] == lottoArray[i]) {
				count++;
			}
		}
		if (count == 6) {
			System.out.println("당첨");
		} else {
			System.out.println("꽝");
		}

		// 선택 정렬 알고리즘

		int[] intArray = { 23, 456, 213, 32, 464, 1, 2, 4 };

//	1. 해당 배열에서 최댓값을 찾아 해당 위치의 값과 배열의 마지막 값을 swap 한다.
//	2. 배열의 마지막을 제외한 나머지 값들 중 최댓값을 찾아 
//	   해당 위치의 값과 배열의 끝에서 두번째 값을 swap 한다.
//	3. 위 과정을 반복하면 정렬이 잘 될겁니다.

		for (int i = 0; i < intArray.length - 1; i++) {
			for (int j = i + 1; j < intArray.length; j++) {
				if (intArray[i] > intArray[j]) {
					int tmp = intArray[i];
					intArray[i] = intArray[j];
					intArray[j] = tmp;
				}
			}
		}
		printArray(intArray);

	}// 메인 끝
		// static 작성
		// 숫자 배열 두개를 입력(파라미터)받아
		// 전부 일치하는 경우 true 리턴
		// 1개라도 틀리면 false를 리턴하는 함수 만들기

	static boolean lotto2(int[] winArr, int[] myArr) {
		int count = 0;
		for (int i = 0; i < winArr.length; i++) {
			if (winArr[i] == myArr[i]) {
				count++;
			}
		}
//		if(count == 6) {
//			return true;
//		}
//			return false;
		return (count == 6);
	}

	static int[] makeLotto() {
		int idx = 0;
		int[] lottoArray = new int[6];
		while (idx < 6) {
			int randInt = (int) (Math.random() * 45) + 1;
			boolean isDuple = false;

			// 중복체크 (중복되면 isDuple은 true)
			for (int i = 0; i < lottoArray.length; i++) {
				if (lottoArray[i] == randInt) {
					isDuple = true;
				}
			}

			if (isDuple == false) {
				lottoArray[idx] = randInt;
				idx++;
			}
		}
		Arrays.sort(lottoArray);
		return (lottoArray);
		// 로또 정렬
//		for (int i = 0; i < lottoArray.length - 1; i++) {
//			// 최댓값 구하기
//			int maxIdx = 0;
//			int maxVal = lottoArray[0];
//			for (int j = 0; j < lottoArray.length-i; j++) {
//			}
//			if (lottoArray[j] > maxVal) {
//				maxVal = lottoArray[j];
//				maxIdx = j;
//			}
//
//			// maxVal에 최댓값이 담겨있다
//			// maxIdx에 최댓값의 인덱스가 담겨있다.
//
//			// 자리바꾸기
//			int temp = lottoArray[maxIdx];
//			lottoArray[maxIdx] = lottoArray[lottoArray.length - 1 - i];
//			lottoArray[lottoArray.length - 1 - i] = temp;
//		}
	}

	static void printArray(int[] intArray) {
		for (int i = 0; i < intArray.length; i++) {
			if (i == intArray.length - 1) {
				System.out.println(intArray[i]);
			} else {
				System.out.print(intArray[i] + ", ");
			}
		}

	}

	static void printArray(String[] strArray) {

		for (int i = 0; i < strArray.length; i++) {
			if (i == strArray.length - 1) {
				System.out.println(strArray[i]);
			} else {
				System.out.print(strArray[i] + ", ");
			}
		}
	}

}
