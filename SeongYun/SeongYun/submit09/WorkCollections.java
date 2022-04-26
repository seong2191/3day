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
		
		//Q1-2
		for(int i = 0 ; i < ArrayList.size(); i++) {
			System.out.print(ArrayList.get(i) + " ");
		}
		System.out.println("\n=============================\n");
		//Q1-3
		ArrayList<Integer> ArrayList2 = new ArrayList<Integer>();
		for(int i = 0; i < ArrayList.size(); i++) {
			if(ArrayList2.contains(ArrayList.get(i)) == false)
				ArrayList2.add(ArrayList.get(i));
		}System.out.println(ArrayList2);
		
		//Q1-4
		Collections.sort(ArrayList2);
		System.out.println(ArrayList2);
		
		//Q1-5
		Collections.sort(ArrayList2,Collections.reverseOrder());
		System.out.println(ArrayList2);
		
		
		
		//Q2
		ArrayList<String> wife = new ArrayList<String>();
		ArrayList<String> husband = new ArrayList<String>();
		
		wife.add("냉장고");
		wife.add("세탁기");
		wife.add("에어컨");
		husband.add("노트북");
		husband.add("TV");
		husband.add("에어컨");
		
		System.out.println(wife);
		System.out.println(husband);
		
		wife.retainAll(husband);
		System.out.println(wife);
		
		ArrayList<String> couple = new ArrayList<>(wife);
		couple.removeAll(husband);
		couple.addAll(husband);
		
		System.out.println(couple);
		
		

	}

}
