package ch08_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;

public class CollectionList {

	public static void main(String[] args) {

		// 리스트(ArrayList)의 선언
		// 1.
		ArrayList<String> students = new ArrayList<String>();

		// 2.
		ArrayList<Integer> intList = new ArrayList<Integer>(); // 뒤에 <>안에 생략이 가능하다.

		// Wrapper class는 기본 타입의 데이터를
		// 객체(참조타입 변수)로 사용해야 하는 경우 사용한다.

		int intVal = 12;

		// 기본 타입의 데이터를(intVal) Wrapper 클래스의 인스턴스로 변환
		// (=Wrapper 객체로 만들기)
		// 박싱(boxing)
		Integer num = new Integer(intVal);

		// 오토 박싱(Auto boxing)
		Integer autoNum = intVal;
		System.out.println(autoNum); // 12

		// Wrapper 클래스 객체에 저장된 값을 기본 타입의 데이터로 꺼내기
		// 언박싱(Unboxing)
		int temp = autoNum.intValue();
		System.out.println(temp); // 12

		// 오토 언박싱
		int temp2 = autoNum;
		System.out.println(temp2); // 12

		// 한졸 요약
		// 오토 박싱과 언박싱이 되므로, Wrapper Class를 사용하는데 불편함은 없다.

		System.out.println("\n=============================================\n");

		// ArrayList에 값 담기
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(4);
		intList.add(5);

		System.out.println(intList); // [1, 2, 3, 4, 5] 괄호와 콤마는 자동으로 찍힘

		students.add("두둥");
		students.add("탁");
		students.add("둥둥둥");
		students.add("점심밥");
		students.add("제육?");

		// 제너릭<> 타입과 일치하는 데이터만 추가가능
//		students.add(13); -- 실행불가

		System.out.println(students);

		System.out.println("\n=============================================\n");

		// .size()
		// 리스트의 길이를 리턴
		System.out.println(students.size()); // 5

		// 값이 들어있지 않으면 size는 0
		ArrayList<String> tempList = new ArrayList<>();
		System.out.println(tempList.size()); // 0

		// .set(인덱스, 값)
		// 해당 인덱스의 값을 괄호 안 값으로 교체
		students.set(2, "두둥탁");
		System.out.println(students); // 둥둥둥 -> 두둥탁으로 교체

		// .contains(값)
		// 리스트 안에 해당 값이 존재하는지 체크
		// 존재하면 true, 없으면 false를 리턴
		System.out.println(students.contains("김치찌개")); // 괄호 안 값이 없으므로 false 출력
		System.out.println(students.contains("점심밥")); // 괄호 안 값이 있으므로 true 출력

		// indexOf(값)
		// 리스트 안에 해당 값이 어디에 존재하는지 체크
		// 존재하면 해당 인덱스 리턴, 없으면 -1을 리턴
		System.out.println(students.indexOf("제육?")); // 4번째 인덱스에 있다해서 4 출력
		System.out.println(students.indexOf("칼국수")); // 완전히 일치해야한다. 칼국수라는 단어는 없으므로 -1 출력
		// -1 리턴 여부로 contains처럼 사용 가능

		// .get(인덱스) *중요
		// 해당 인덱스의 값을 리턴
		students.get(0);
		System.out.println(students.get(0)); // 인덱스 0번째 자리에 두둥, 두둥 출력

		// .isEmpty()
		// 리스트가 비어있는지 체크
		// 비어있다면 true, 아니라면 false 리턴
		// .size() == 0 과 같다.
		System.out.println(students.isEmpty()); // false 출력
		System.out.println(tempList.isEmpty()); // 72번행에 값이 들어가 있지 않으므로 true 출력

		// .remove(인덱스)
		// 해당 인덱스의 데이터를 삭제
		students.remove(2);
		System.out.println(students); // 2번 인덱스의 두둥이 제거되어 [두둥, 탁, 점심밥, 제육?]이 출력

		// .remove(값)
		// 리스트에 해당 값이 있으면 삭제
		// 없으면 삭제 안함
		students.remove("점심밥");
		System.out.println(students); // 점심밥 삭제되고 [두둥, 탁, 제육?] 출력
		students.remove("아무말");
		System.out.println(students); // 에러나지 않고 그대로 위와 그대로 출력

		// .clear()
		// 해당 리스트를 비움(size가 0이 됨)
		students.clear();
		System.out.println(students); // 내용이 클리어되어 [] < 출력

		// 초기화 가능
		intVal = 0;
		students.add("된장찌개");
		students = new ArrayList<String>();
		System.out.println(students); // 초기화 됐기 때문에 [] < 출력

		System.out.println("\n=============================================\n");

		// for문으로 ArrayList 제어
		students.add("두둥");
		students.add("탁");
		students.add("둥둥둥");
		students.add("점심밥");
		students.add("제육?");

		for (int i = 0; i < students.size(); i++) {
			students.set(i, (i + 1) + ". " + students.get(i));
		}
		System.out.println(students); // [1. 두둥, 2. 탁, 3. 둥둥둥, 4. 점심밥, 5. 제육?] 출력

		System.out.println("\n=============================================\n");

		// 리스트 복사
		ArrayList<String> copyList = new ArrayList<String>();

		for (int i = 0; i < students.size(); i++) {
			copyList.add(students.get(i));

		}
		System.out.println(copyList); // copyList에 student값을 복사했다.

		// 리스트 복사 2
		ArrayList<String> copyList2 = new ArrayList<>();

		copyList2.addAll(students);
		System.out.println(copyList2); // 위와 동일

		// 리스트 복사 3
		ArrayList<String> copyList3 = new ArrayList<String>(students);
		System.out.println(copyList3); // 위와 동일 ㅡㅡ

		System.out.println("\n=============================================\n");

		// 향상된 for문
		// = (foreach 문)
		for (String stu : students) {
			System.out.println(stu);
		} // 1. 두둥 2. 탁 ,,, 5. 제육? < 세로로 출력
			// 인덱스가 존재하는 ArrayList에서는 큰 메리트가 있지는 않다.

		for (int i = 0; i < students.size(); i++) {
			System.out.println(students.get(i));
		} // 위 와 동일한 출력

		System.out.println("\n=============================================\n");

		// forEach 문
		students.forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		}); // 잘 안씀

		// 람다식
		students.forEach(stu -> System.out.println(stu));
		students.forEach(stu -> {
			System.out.println(stu);
			System.out.println(stu);
		});

		System.out.println("\n=============================================\n");

		// 값을 주면서 리스트 선언
		ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(30, 23, 1, 66, 34, 143));

		numbers.add(30);
		numbers.add(23);
		numbers.add(1);
		numbers.add(66);
		numbers.add(34);
		numbers.add(143); // 위와 동일

		// 정렬
		// 알고리즘(버블정렬, 선택정렬)
		for (int k = 0; k < numbers.size(); k++) {
			for (int i = 0; i < numbers.size() - 1 - k; i++) {
				// i > i+1 하면 오름차순
				// i < i+1 하면 내림차순
				if (numbers.get(i) > numbers.get(i + 1)) {
					int tmp = numbers.get(i);
					numbers.set(i, numbers.get(i + 1));
					numbers.set(i + 1, tmp);
				}
			}
		}
		System.out.println(numbers);
		
		// 제공되는 메소드로 정렬하기
		// 오름차순
		Collections.sort(numbers);
		
		// 내림차순
		Collections.sort(numbers,Collections.reverseOrder());
		System.out.println(numbers);
		
		// 주의사항
		// 버블정렬 또한 필수로 사용할 수 있도록 하세요
	}

}// 메인 끝
