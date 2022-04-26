package SeongYun.submit06;

public class Work6 {

	public static void main(String[] args) {

		// 명함 만들기

		makeCard("김성윤", "010-2086-2191", "ksy21912@gmail.com");
		
		// n층짜리 트리만들기
		makeTree(4);
		makeTree(7);
		
		// 십진수를 이진수(String 타입)으로 리턴해주는
		// makeBinary(int 타입) 함수
		
		String binaryString = Integer.toBinaryString(23);
		System.out.println(binaryString);
		String hexString = Integer.toHexString(23);
		System.out.println(hexString);
		
		
	} // 메인 끝나는 시점

	static void makeCard(String name, String phoneNum, String email) {
		System.out.println("\n============================\n");
		System.out.println("이름 : " + name);
		System.out.println("연락처 : " + phoneNum);
		System.out.println("이메일 : " + email);
		System.out.println("\n============================\n");
	}

	static void makeTree(int num) {
		String star = "*";
		for (int i = 0; i < num; i++) {
			String blank = "";
			for (int j = 0; j < num-i  ; j++) {
				blank += " ";
			}
			System.out.println((i+1) + ": " + blank + star);
			star += "**";
		}
	}
	
	static String makeBinary(int num) {
		// 30이 들어왔다.
		// 30을 2로 나눠서 나머지 0 / 몫은 15
		// 15를 2로 나눠서 나머지 1 / 몫은 7
		// 7을 2로 나눠서 나머지 1 / 볷은 3
		// 3을 2로 나눠서 나머지 1 / 몫은 1
		
		String result = "";
		while(true) {
			result += num % 2;
			if(num==1) {
				break;
			}
			num /= 2;
		}
		return reverse(result);
	}
	
	static String reverse(String str) {
		// 로꾸꺼 (String을 뒤집는 녀석)
				String revStr = "";
				for(int i = str.length()-1; i>=0;i--) {
					revStr += str.substring(i,i+1);
				}
				return revStr;

		
	}
}
