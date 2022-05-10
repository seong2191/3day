package SeongYun.submit12;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryMain {

	public static void main(String[] args) {
		Library library = Library.getInstance();

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("행동을 선택해주세요");
			System.out.println("1. 책 입고 | 2. 책 대여 | 3. 책 목록 | 4. 책 검색 | 5. 종료");
			System.out.print(">>> ");

			int select = Integer.parseInt(sc.nextLine());

			if (select == 1) {
				// 책 입고
				System.out.println("책 번호를 입력해주세요");
				System.out.print(">>> ");

				int no = Integer.parseInt(sc.nextLine());

				Book book = library.selectBook(no);

				if (book.isBorrow()) {
					library.setBookBorrow(no);
					System.out.println(book.getName() + "가 입고되었습니다.");
				} else {
					System.out.println("이미 입고중입니다.");
				}

			} else if (select == 2) {
				// 책 대여
				System.out.println("책 제목을 입력해주세요");
				System.out.print(">>> ");

				String keyword = sc.nextLine();

				ArrayList<Book> searchList = library.getSearchList(keyword);

				if (searchList.size() == 0) {
					System.out.println("해당 책이 존재하지 않습니다.");
				} else if (searchList.size() == 1) {
					Book book = library.selectBook(searchList.get(0).getNo());
					if (!book.isBorrow()) {
						library.setBookBorrow(searchList.get(0).getNo());
						System.out.println(searchList.get(0).getName() + "을 대여하셨습니다.");
					} else {
						System.out.println("이미 대여중입니다.");
					}
				} else {
					for (Book book : searchList) {
						System.out.println(book);
					}

					System.out.println("책 번호를 입력해주세요");
					System.out.print(">>> ");
					int no = Integer.parseInt(sc.nextLine());
					Book book = library.selectBook(no);

					if (!book.isBorrow()) {
						library.setBookBorrow(book.getNo());
						System.out.println(book.getName() + "을 대여하셨습니다.");
					} else {
						System.out.println("이미 대여중입니다.");
					}
				}
			} else if (select == 3) {
				// 책 목록
				library.showBookList();
			} else if (select == 4) {
				// 책 검색
				System.out.println("책 제목을 입력해주세요");
				System.out.print(">>> ");

				String name = sc.nextLine();

				ArrayList<Book> searchList = library.getSearchList(name);

				for (Book book : searchList) {
					System.out.println(book);
				}

			} else if (select == 5) {
				// 종료
				System.out.println("종료합니다.");
				break;
			}

		}

	}

}