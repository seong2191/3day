package SeongYun.submit11;

import java.util.ArrayList;

import ch09_class.school.Student;

public class ProductMain {

	public static void main(String[] args) {
		
		
		Product one = new Product();
		one.setName("냉장고");
		one.setPrice(2000000);
		
		Product two = new Product();
		two.setName("TV");
		two.setPrice(1000000);
		
		Product three = new Product();
		three.setName("에어컨");
		three.setPrice(800000);
		
		Product four = new Product();
		four.setName("컴퓨터");
		four.setPrice(1300000);
		
		Product five = new Product();
		five.setName("선풍기");
		five.setPrice(100000);
		
		// 위와 동일
		/* Product ref = new Product("냉장고", 2000000);
		/* Product tv = new Product("TV", 1000000);
		/* Product air = new Product("에어컨", 800000);
		/* Product com = new Product("컴퓨터", 1300000);
		/* Product fan = new Product("선풍기", 100000);
		 * */
		
		ArrayList<Product> proList = new ArrayList<>();
		proList.add(one);
		proList.add(two);
		proList.add(three);
		proList.add(four);
		proList.add(five);
		
		
		// 버블정렬
		for (int k = 0; k < proList.size(); k++) {
			for (int i = 0; i < proList.size() - 1 - k; i++) {
				// i > i+1 하면 오름차순
				// i < i+1 하면 내림차순
				if (proList.get(i).getPrice() < proList.get(i+1).getPrice()) {
					Product tmp = proList.get(i);
					proList.set(i, proList.get(i + 1));
					proList.set(i + 1, tmp);
				}
			}
		}
		
		//toString은 생략가능
		for(int i = 0; i < proList.size(); i++) {
			System.out.println(proList.get(i).toString());
		}
		
		
		// TV 인덱스뽑기
		for(int i = 0; i < proList.size(); i++) {
			if(proList.get(i).getName().equals("TV")) {
				System.out.println(i);
			}
		}
		
		
		
		

	}

}
