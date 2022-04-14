package ch03_system_inout;

public class Comments {
	// 자바 문서(javadoc) 주석
	/**
	 * 좋아하는 과일
	 * 
	 */
	static String strawberry = "딸기";
	

	public static void main(String[] args) {
//주석(comment)
		// 단일 주석(코드 앞에//)
		// 단축키[ctrl + /)

		/*
		 * 다 중 주 석
		 *
		 * 작성자, 작성일 등
		 */

		// 자바 문서(javadoc) 주석
		/**
		 * 가장 맛있는 과일은
		 */
		
		System.out.println(strawberry);
		
		//TODO 주석
		//개발 중에 구현해야 할 부분에 대해서
		//미리 작성을 해놓는 경우 이용
		
		//TODO 딸기를 콘솔창에 출력해야함
		
		//위 카테고리에 윈도우->뷰->tasks에 TODO 리스트가 나옴(보통 개발전에 리스트 확인하고 시작하는 편이 좋다)

	}

}
