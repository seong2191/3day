package ch08_collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CollectionSet {

	public static void main(String[] args) {

		// 집합(HashSet)의 선언
		HashSet<String> stuSet = new HashSet<String>();
		HashSet<String> stuSet2 = new HashSet<>(); // 생략 가능
		// 다형성을 이용(나중에 배움)
		Set<String> stuSet3 = new HashSet<String>(); // 생략 가능

		// .add() 값을 추가
		stuSet.add("홍길동");
		stuSet.add("이순신");
		stuSet.add("삼국지");

		// set은 담은 데이터의 순서를 보장하지 않는다.
		System.out.println(stuSet);

		// 중복값을 허용하지 않음. 에러도 안남
		stuSet.add("삼국지");
		System.out.println(stuSet);

		System.out.println("\n==================================\n");

		// .contains(값)
		// 해당 값이 Set 안에 있으면 true, false
		System.out.println(stuSet.contains("관우")); // false

		// .size()
		// Set 안에 있는 데이터의 개수를 리턴
		System.out.println(stuSet.size());

		System.out.println("\n==================================\n");

		// Set 조회
		// 1. while문 사용
		Iterator<String> iterator = stuSet.iterator();
		while (iterator.hasNext()) {
			String name = iterator.next();
			System.out.println(name);
		}

		// 2. 향상된 for문
		for (String name : stuSet) {
			System.out.println(name);
		}
		// 3. forEach 사용
		// 람다식의 경우 명령어가 한줄이면 중괄호{} 와 세미콜론; 이 필요없다.
		// 두 줄 부터는 중괄호와 세미콜론 필수
		stuSet.forEach(name -> System.out.println(name));
		stuSet.forEach(name -> {
			System.out.println(name);
			System.out.println(name);
		});

		System.out.println("\n==================================\n");

		// Set은 집합을 쓰는 경우가 아니라면 잘 쓰지 않는다.
		// 그나마 Set을 사용한다면 Set의 중복을 허용하지 않는 속성을 이요하는 경우

		// 10~20 까지 랜 덤 숫자 10개담기
		ArrayList<Integer> ArrayList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			int randInt = (int) ((Math.random() * 11) + 10);
			ArrayList.add(randInt);
		}

		// ArrayList에서 HashSet으로 변환
		HashSet<Integer> tempSet = new HashSet<>();
		tempSet.addAll(ArrayList);
		System.out.println(tempSet);

		// HashSet에서 ArrayList로 변환
		ArrayList.clear();
//		ArrayList<Integer> ArrayList = new ArrayList<Integer>();
		ArrayList.addAll(tempSet);
		System.out.println(ArrayList);

	}

}
