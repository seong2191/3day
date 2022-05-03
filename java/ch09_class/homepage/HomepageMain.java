package ch09_class.homepage;

import java.util.Scanner;

public class HomepageMain {

	public static void main(String[] args) {
		// 막아놨기 때문에 빨간줄
//		MemberDB memberDB = new MemberDB();
//		MemberDB.instance;
		
		MemberDB memberDB = MemberDB.getInstance();
		BoardDB boardDB = BoardDB.getInstance();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("행동을 선택해주세요");
			System.out.println("1. 회원가입 | 2. 회원목록조회 | 3. 로그인 | 4. 종료");
			System.out.print(">>> ");
			
			int command = Integer.parseInt(sc.nextLine());
			
			if(command == 1) {
				//회원가입
				System.out.println("아이디를 입력하세요");
				System.out.print(">>> ");
				String id = sc.nextLine();
				System.out.println("비밀번호를 입력하세요");
				System.out.print(">>> ");
				String pw = sc.nextLine();
				
				// MemberDB 의 MemberList에 해당 id와 
				// pw를 가지는 Member 추가하기
				memberDB.regist(id,pw);
				
			}else if(command == 2) {
				//회원목록조회
				memberDB.printMembers();
				
			}else if(command == 3) {
				// 로그인
				System.out.println("아이디를 입력하세요");
				System.out.print(">>> ");
				String id = sc.nextLine();
				System.out.println("비밀번호를 입력하세요");
				System.out.print(">>> ");
				String pw = sc.nextLine();
				
				// id가 존재하면 해당 member 리턴
				// 존재하지 않으면 텅빈 member 리턴
				Member member = memberDB.getMember(id);
				
				// 널체크
//				if(member != null) {
//					
//				}
				
				if(pw.equals(member.getPassWord())) {
					// 로그인 성공
					System.out.println("로그인 되었습니다.");
					
					while(true) {
						// 게시글 목록 출력
						boardDB.printBoards();
						System.out.println("행동을 선택해주세요.");
						System.out.println("1. 글쓰기 | 2. 글조회 3. 로그아웃");
						System.out.print(">>> ");
						int select = Integer.parseInt(sc.nextLine());
						
						if(select == 1) {
							//글쓰기
							System.out.println("글 제목을 입력하세요");
							System.out.print(">>> ");
							String title = sc.nextLine();
							System.out.println("글 내용을 입력하세요");
							System.out.print(">>> ");
							String content = sc.nextLine();
							
							// BoardDB에 글 등록 메소드 만들기
							// 글 제목, 글 내용, 작성
							boardDB.write(title, content, member.getId());
							
							
						}else if(select == 2) {
							// 글조회
							System.out.println("글 번호를 입력해주세요");
							System.out.print(">>> ");
							int no = Integer.parseInt(sc.nextLine());
							// 해당 글의 내용까지 출력
							if(!boardDB.selectBoard(no)) {
								System.out.println("해당 게시글이 존재하지 않습니다.");
							};
							
						}else if(select == 3) {
							//TODO 로그아웃
							System.out.println("로그아웃 되었습니다.");
							break;
						}
						
						
						
						
					}
					
				}else {
					System.out.println("아이디 혹은 비밀번호가 틀립니다.");
				}
				
				
			}else if(command == 4) {
				//TODO 종료
				System.out.println("종료합니다.");
				break;
			}else {
				System.out.println("명령어x");
			}
		}
		
		

	}

}
