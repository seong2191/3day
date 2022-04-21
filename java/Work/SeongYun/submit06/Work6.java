package SeongYun.submit06;

public class Work6 {

	public static void main(String[] args) {

		// 명함 만들기

		makeCard("김성윤", "010-2086-2191", "ksy21912@gmail.com");
		
		// n층짜리 트리만들기
		makeTree(4);
		makeTree(7);

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
	
	
	
	
}
