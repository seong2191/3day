package SeongYun.submit12;

import java.util.ArrayList;

public class BookDB {
	private ArrayList<Book> bookList = new ArrayList<>();
	private BookDB() {
	}
	
	public void addBook(String title) {
		bookList.add(new Book(bookList.size()+1,title, false));
	}
	
	private static BookDB instance = new BookDB();
	
	
	public static BookDB getInstance() {
		return instance;
	}
	
	
	public void lookBook() {
		for(int i = 0; i < bookList.size(); i++) {
			System.out.println(bookList.get(i));
		}
	}
	
	public void settingBook() {
		
		String strBooks = "삼국지, 해리포터와 마법사의 돌, 해리포터와 비밀의 방 , 해리포터와 아즈카반의 죄수,"
				+ "해리포터와 불사조 기사단, 해리포터와 혼혈왕자, 해리포터와 죽음의 성물,어린왕자, 나의 라임 오렌지나무, "
				+ "이것이 자바다, 좋은생각, 반지의 제왕: 반지 원정대, 반지의 제왕: 두 개의 탑, 반지의 제왕: 왕의 귀환, "
				+ "토익보카, 개미";
		
		String[] addArray = strBooks.split(",");
		
		for(int i = 0 ; i < addArray.length; i++) {
			addArray[i] = addArray[i].trim();
		}
		
		for(int i = 0 ; i < addArray.length; i++) {
			bookList.add(new Book(i+1, addArray[i], false));
		}
	}
	
	
	// 책 검색
	public void searchBook(String title) {
		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getTitle().contains(title)) {
				System.out.println(bookList.get(i));
			}
		}
	}

}
