package SeongYun.submit01;

public class work {

	public static void main(String[] args) {

		String name = "김성윤";
		int age = 27;
		String email = "ksy21912@gmail.com";

		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("이메일 : " + email);

		System.out.println("\n================================\n");

//               enigma = enigma.replace("너", "");
//               enigma = enigma.replace("구", "");
//               enigma = enigma.replace("리", "");

//		enigma = enigma.replace("너", "").replace("구", "").replace("리", "");

		String enigma = "너오구늘리뭐너먹구지리";
		System.out.println(enigma);
		String one = enigma.replace("너", "");
		System.out.println("1차 해독[너 제거]: " + one);
		String two = one.replace("구", "");
		System.out.println("2차 해독[구 제거]: " + two);
		String three = two.replace("리", "");
		System.out.println("3차 해독[리 제거]: " + three);

		System.out.println("\n================================\n");
		
		String example = "278";
		String str1 = example.substring(0, 1); // 끝 인덱스는 자르기 때문에 인덱스 0에 대한 것만 해당이므로 2
		System.out.println(str1);
		String str2 = example.substring(1, 2); // 끝 인덱스는 자르기 때문에 인덱스 1에 대한 것만 해당이므로 7
		String str3 = example.substring(2, 3); // 끝 인덱스는 자르기 때문에 인덱스 2에 대한 것만 해당이므로 8

		int int1 = Integer.parseInt(str1);
		int int2 = Integer.parseInt(str2);
		int int3 = Integer.parseInt(str3);

		int result = int1 + int2 + int3;
		System.out.println("결과는 :" + result);

//		String example = "278";
//		int result = Integer.parseInt(example.substring(0,1))
//				   + Integer.parseInt(example.substring(1,2))

//				   + Integer.parseInt(example.substring(2,3));
//		
//		int result = int1 + int2 + int3;
//		System.out.println("결과는 :"+result);

	}

};
