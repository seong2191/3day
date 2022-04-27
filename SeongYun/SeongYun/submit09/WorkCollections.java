package SeongYun.submit09;

import java.util.ArrayList;
import java.util.Collections;

public class WorkCollections {

	public static void main(String[] args) {
		
		// 정수를 담을 수 있는 ArrayList 객체를 생성하고,
		// 10부터 20 사이의 랜덤 숫자를 10개 담으시오.
		// Q1-1
		ArrayList<Integer> ArrayList = new ArrayList<Integer>();
		for(int i = 0 ; i < 10; i++) {
			int randInt = (int)((Math.random()*11)+10);
			ArrayList.add(randInt);
		}
		System.out.println(ArrayList);
		// [13, 19, 11, 15, 13, 17, 17, 12, 20, 12]
		
		//Q1-2
		for(int i = 0 ; i < ArrayList.size(); i++) {
			System.out.print(ArrayList.get(i) + " ");
		} // 13 19 11 15 13 17 17 12 20 12
		System.out.println("\n=============================\n");
		
		//Q1-3
		ArrayList<Integer> ArrayList2 = new ArrayList<Integer>();
		for(int i = 0; i < ArrayList.size(); i++) {
			if(ArrayList2.contains(ArrayList.get(i)) == false)
				ArrayList2.add(ArrayList.get(i));
			// if(ArrayLIst2.indexOf(ArrayList.get(i)) == -1){ << 가지고 있지 않으면 -1이 출력되니까
			// ArrayList2.add(ArrayList.get(i));}
		}System.out.println(ArrayList2);
		// 1-3 (새로운 배열 없이 중복 제거)
		for (int i = 0; i < ArrayList.size()-1; i++) {
			// j를 뒤에서부터 앞으로 순회시킨다(앞에서 부터 비교하면 놓치는 부분이 생김)
			for(int j = ArrayList.size()-1; j > i ; j--) { // i+1은 i번째 수랑 겹치면 안되니까
				if(ArrayList.get(i) == ArrayList.get(j)) {
					ArrayList.remove(j);
				}
			}
		}
		System.out.println(ArrayList);
		
		
		//Q1-4
		Collections.sort(ArrayList2);
		System.out.println(ArrayList2);
		
		//Q1-5
		Collections.sort(ArrayList2,Collections.reverseOrder());
		System.out.println(ArrayList2);
		// [단축키 Alt + shift + R]
		// 변수명, 함수명 한번에 바꾸
		
		
		
		//Q2
		ArrayList<String> wifeList = new ArrayList<String>();
		wifeList.add("냉장고");
		wifeList.add("세탁기");
		wifeList.add("에어컨");
		
		System.out.println("\n=============================\n");
		
		ArrayList<String> husbandList = new ArrayList<String>();
		husbandList.add("노트북");
		husbandList.add("TV");
		husbandList.add("에어컨");
		
		System.out.println(wifeList);
		System.out.println(husbandList);
		
		// 서로 사고싶은 물건 목록(교집합)
		ArrayList<String> eachList = new ArrayList<>();
		
		for(int i = 0; i < wifeList.size(); i++) {
			if(husbandList.indexOf(wifeList.get(i)) != -1) {
				eachList.add(wifeList.get(i));
			}
		}
		System.out.println(eachList);
		// 교집합을 위한 .retainAll() 이용
		eachList = new ArrayList<>(); // 초기화 개념
		eachList.addAll(wifeList);
		System.out.println(eachList);
		eachList.retainAll(husbandList);
		System.out.println(eachList);
		
		// 겹치지 않게 다 사는 목록(합집합)
		ArrayList<String> allBuy = new ArrayList<String>();
		for(int i = 0; i < wifeList.size(); i++) {
			allBuy.add(wifeList.get(i));
		}
		System.out.println(allBuy);
		
		for(String item : husbandList) {
			if(allBuy.indexOf(item) == -1) {
				allBuy.add(item);
			}
		}
		System.out.println(allBuy);

	}

}
