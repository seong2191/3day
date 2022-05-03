package SeongYun.submit10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class submit10 {

	public static void main(String[] args) {
		// Q1

		makeLotto();

		System.out.println("\n===============================\n");

		// Q2

		HashMap<String, String> infoMap = new HashMap<>();

		infoMap.put("a001", "1234a");
		infoMap.put("b001", "1234b");
		infoMap.put("c001", "1234c");
		infoMap.put("d001", "1234d");
		infoMap.put("e001", "1234e");

		Scanner scanner = new Scanner(System.in);
		System.out.println("아이디를 입력해주세요");
		System.out.print(">>> ");
		String inputId = scanner.nextLine();

		System.out.println("비밀번호를 입력해주세요");
		System.out.print(">>> ");
		String inputPw = scanner.nextLine();

		if (infoMap.containsKey(inputId)) {
			if (infoMap.get(inputId).equals(inputPw)) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("비밀번호가 틀렸습니다.");
			}	

		} else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
		
		
	}// 메인 끝

	static void makeLotto() {
		HashSet<Integer> makeLotto = new HashSet<Integer>();
		while (true) {
			if (makeLotto.size() < 6) {
				int randInt = (int) ((Math.random() * 45) + 1);
				makeLotto.add(randInt);

			} else {
				break;
			}
		}
		System.out.println(makeLotto);
		ArrayList<Integer> Lotto = new ArrayList<>(makeLotto);
		System.out.println(Lotto);
		Collections.sort(Lotto);
		System.out.println(Lotto);
	}

}
