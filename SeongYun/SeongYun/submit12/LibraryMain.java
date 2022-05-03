package SeongYun.submit12;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryMain {

	public static void main(String[] args) {
		
		BookDB bookDB = BookDB.getInstance();
		bookDB.settingBook();
		
		
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("행동을 선택해주세요");
			System.out.println("1. 책 입고 | 2. 책 대여 | 3. 책 목록 | 4. 책 검색 | 5. 종료");
			System.out.print(">>> ");
			
			int command = Integer.parseInt(sc.nextLine());
			
			if(command == 1) {
				// 책 입고
				System.out.println("책 이름을 입력해주세요");
				
			}else if(command == 2) {
				// 책 대여
				System.out.println("책 번호를 입력해주세요");
				System.out.print(">>> ");
				
//				for(int i = 0; )
			}else if(command == 3) {
				// 책 목록
				bookDB.lookBook();
			}else if(command == 4) {
				// 책 검색
				System.out.println("책 이름을 입력해주세요");
				System.out.print(">>> ");
				String searchTitle = sc.nextLine();
				bookDB.searchBook(searchTitle);
			}else if(command == 5) {
				// 종료
				System.out.println("종료합니다");
				break;
			}
		}
		

	}

}
