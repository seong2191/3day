package SeongYun.submit13;

import java.util.ArrayList;
import java.util.Scanner;


public class SoccerMain {

	public static void main(String[] args) {
		
		SoccerDB soccerdb = SoccerDB.getInstance();

		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("행동을 선택해주세요");
			System.out.println("1. 선수 목록 || 2. 선수 검색 || 3. 종료");
			System.out.print(">>> ");
			
			int select = Integer.parseInt(sc.nextLine());
			
			if(select == 1) {
				soccerdb.showPlayerList();
			}else if(select == 2) {
				System.out.println("선수 이름을 입력해주세요");
				System.out.print(">>> ");
				
				String name = sc.nextLine();
				
				ArrayList<Soccer> searchList = soccerdb.getSearchList(name);
				
				for(Soccer soccer : searchList) {
					System.out.println(soccer);
				}
			}else if(select == 3) {
				System.out.println("종료");
				break;
			}
			
		}

	}

}
