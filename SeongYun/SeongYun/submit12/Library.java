package SeongYun.submit12;

import java.util.ArrayList;

public class Library {
	private ArrayList<Book> bookList = new ArrayList<Book>();
	
	private static Library instance = new Library();
	
	private Library() {
		String strBooks = "삼국지, 해리포터와 마법사의 돌, 해리포터와 비밀의 방 , 해리포터와 아즈카반의 죄수,해리포터와 불사조 기사단, 해리포터와 혼혈왕자, 해리포터와 죽음의 성물,어린왕자, 나의 라임 오렌지나무, 이것이 자바다, 좋은생각, 반지의 제왕: 반지 원정대, 반지의 제왕: 두 개의 탑, 반지의 제왕: 왕의 귀환, 토익보카, 개미";
		
		String[] strArray = strBooks.split(",");
		
		for(int i = 0; i < strArray.length; i++) {
			strArray[i] = strArray[i].trim();
		}
		
		for(int i = 0; i < strArray.length; i++) {
			bookList.add(new Book(bookList.size() + 1, strArray[i]));
		}
	}
	
	public static Library getInstance() {
		return instance;
	}
	
	// 책 목록 보여주기
	public void showBookList() {
		for(Book book : bookList) {
			System.out.println(book);
		}
	}
	
	// 책 추가
	public void addBook(Book book) {
		bookList.add(book);
	}

	// 책 조회 (책 번호 입력받음)
	public Book selectBook(int no) {
		return bookList.get(no - 1);
	}
	
	// 책 대여 상태 변환 (상태 반전)
	public void setBookBorrow(int no) {
		bookList.get(no-1).setBorrow(!bookList.get(no-1).isBorrow());
	}
	
	// bookList 사이즈 리턴
	public int getBookListSize() {
		return bookList.size();
	}
	
	// 검색 시 검색어를 포함하는 책 목록 리턴
	public ArrayList<Book> getSearchList(String keyword){
		ArrayList<Book> resultList = new ArrayList<>();
		for(Book book : bookList) {
			if(book.getName().indexOf(keyword) != -1) {
				resultList.add(book);
			}
		}
		return resultList;
	}
	
	
	
}