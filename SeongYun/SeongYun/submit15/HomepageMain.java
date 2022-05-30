package SeongYun.submit15;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import SeongYun.submit15.model.MemberVO;
import SeongYun.submit15.model.TextLookVO;
import SeongYun.submit15.service.MemberService;
import SeongYun.submit15.service.TextLookService;

public class HomepageMain {

	public static void main(String[] args) {
		MemberService memService = MemberService.getInstance();
		TextLookService textService = TextLookService.getInstance();

		ArrayList<TextLookVO> write = textService.getTextList();

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("행동을 선택해주세요");
			System.out.println("1. 회원가입 | 2. 로그인 | 3. 종료");
			System.out.print(">>> ");

			int command = 0;
			try {
				command = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자로 입력해주세요.");
				continue;
			}

			if (command == 1) {
				// 회원가입
				System.out.println("아이디를 입력해주세요.");
				System.out.print(">>> ");
				String id = sc.nextLine();

				System.out.println("비밀번호를 입력해주세요.");
				System.out.print(">>> ");
				String pw = sc.nextLine();

				MemberVO temp = new MemberVO(id, pw);
				memService.insertMem(temp);

			} else if (command == 2) {
				// 로그인
				System.out.println("아이디를 입력하세요");
				System.out.print(">>> ");
				String id = sc.nextLine();
				System.out.println("비밀번호를 입력하세요");
				System.out.print(">>> ");
				String pw = sc.nextLine();

				MemberVO login = memService.loginMem(id);

				if (pw.equals(login.getMemPassword())) {
					// 로그인 성공
					System.out.println(login.getMemId() + "님 환영합니다.");

					while (true) {
						// 로그인 이후 선택지
						// 게시글 목록 출력
						write = textService.getTextList();
						for (int i = 0; i < write.size(); i++) {
							System.out.println(write.get(i));
						}

						System.out.println("행동을 선택해주세요.");
						System.out.println("1. 글쓰기 | 2. 글조회 3. 로그아웃");
						System.out.print(">>> ");

						int select = 0;
						try {
							select = Integer.parseInt(sc.nextLine());
						} catch (NumberFormatException e) {
							System.out.println("숫자로 입력해주세요.");
							continue;
						}
						if (select == 1) {
							// 글쓰기
							System.out.println("글 제목을 입력하세요");
							System.out.print(">>> ");
							String title = sc.nextLine();
							System.out.println("글 내용을 입력하세요");
							System.out.print(">>> ");
							String content = sc.nextLine();

							SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
							Date dateNow = new Date();
							String time = sdf.format(dateNow);
							TextLookVO temp = new TextLookVO(write.size() + 1, title, content, login.getMemId(), time);
							textService.insertText(temp);

						} else if (select == 2) {
							// 글조회
							System.out.println("글 번호를 입력해주세요");
							System.out.print(">>> ");

							int no = 0;
							try {
								no = Integer.parseInt(sc.nextLine());
							} catch (NumberFormatException e) {
								System.out.println("숫자로 입력해주세요.");
								continue;
							}
							for (int i = 0; i < write.size() + 1; i++) {
								if ((i + 1) == no) {
									System.out.println("제목: " + write.get(i).getTitle());
									System.out.println("작성자: " + write.get(i).getAuthor());
									System.out.println("작성일: " + write.get(i).getTime());
									System.out.println("글내용: " + write.get(i).getContent());
								}
							}
						} else if (select == 3) {
							// TODO 로그아웃
							System.out.println("로그아웃 되었습니다.");
							break;
						}
					}
				} else {
					System.out.println("아이디 혹은 비밀번호가 틀립니다.");
				}

			} else if (command == 4) {
				// TODO 종료
				System.out.println("종료합니다.");
				break;
			} else {
				System.out.println("명령어x");
			}
		}

	}

}
