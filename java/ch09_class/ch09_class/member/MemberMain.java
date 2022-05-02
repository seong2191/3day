package ch09_class.member;

import java.util.Scanner;

public class MemberMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		MemberDB memDB = new MemberDB();
		
		while(true) {
			System.out.println("행동을 선택해주세요");
			System.out.println("1. 회원가입 | 2. 로그인 | 3. 회원목록 | 4. 종료");
			System.out.print(">>> ");
			
			int command = Integer.parseInt(sc.nextLine());
			
			if(command == 1) {
				//TODO 회원가입
				System.out.print("아이디 입력: ");
				String id = sc.nextLine();
				if(memDB.checkDuple(id)) {
					System.out.println("중복된 아이디 입니다.");
				}else {
					System.out.print("비밀번호 입력: ");
					String pw = sc.nextLine();
					System.out.print("이름 입력: ");
					String name = sc.nextLine();
					
					memDB.regist(id, pw, name);
					System.out.println("회원가입에 성공하였습니다.");
				}
			}else if(command == 2) {
				//TODO 로그인
				System.out.print("아이디 입력: ");
				String id = sc.nextLine();
				System.out.print("비밀번호 입력");
				String pw = sc.nextLine();
				
				if(memDB.checkLogin(id, pw)) {
					System.out.println("로그인 성공");
				}
				
			}else if(command == 3) {
				//TODO 회원목록
				memDB.showMemList();
			}else {
				//TODO 종료
				System.out.println("프로그램을 종료합니다.");
			break;
		}
		
		}
		
		

	}

}
