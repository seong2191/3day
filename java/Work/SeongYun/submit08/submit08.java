package SeongYun.submit08;

import java.util.Arrays;

public class submit08 {

	public static void main(String[] args) {

		// 로또 번호 생성기
		// Array에 랜덤 숫자 1~45를 6개 넣어주는데 중복을 허용하지 않아야 함.
		// 출력 후에 오름차순으로 정렬

		
		int[] lottoArray = makeLotto();
		printArray(lottoArray);
		
	
		// 선택 정렬 알고리즘

		int[] intArray = {23, 456, 213, 32, 464, 1, 2, 4};

//	1. 해당 배열에서 최댓값을 찾아 해당 위치의 값과 배열의 마지막 값을 swap 한다.
//	2. 배열의 마지막을 제외한 나머지 값들 중 최댓값을 찾아 
//	   해당 위치의 값과 배열의 끝에서 두번째 값을 swap 한다.
//	3. 위 과정을 반복하면 정렬이 잘 될겁니다.
		
		for(int i = 0; i < intArray.length-1; i++) {
			for(int j = i+1; j < intArray.length; j++) {
				if(intArray[i] > intArray[j]) {
					int tmp = intArray[i];
					intArray[i]=intArray[j];
					intArray[j]=tmp;
				}
			}
		}printArray(intArray);		
		

	}// 메인 끝
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
		}Arrays.sort(lottoArray);
		return(lottoArray);
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
