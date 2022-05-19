package SeongYun.submit14;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BoardMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		Date dateNow = new Date();
		String make = sdf.format(dateNow);

		ArrayList<Board> boardList = new ArrayList<>();

		int no = 0;
		while (true) {
			System.out.println("행동을 선택해주세요");
			System.out.println("1. 글 목록 | 2. 글 쓰기 | 3. 종료");
			System.out.print(">>>");

			int command = Integer.parseInt(sc.nextLine());

			if (command == 1) {
				for (int i = 0; i < boardList.size(); i++) {
					System.out.println(boardList.get(i));
				}

			} else if (command == 2) {

				System.out.print("글 제목을 입력해주세요: ");
				String title = sc.nextLine();

				System.out.print("글 내용을 입력해주세요: ");
				String body = sc.nextLine();
				boardList.add(new Board(no++, title, make, body));

			} else if (command == 3) {
				System.out.println("종료합니다.");
				break;
			}
		}

	}

}
