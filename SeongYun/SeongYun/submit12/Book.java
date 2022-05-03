package SeongYun.submit12;

public class Book {
	private int no;
	private String title;
	private boolean isborrow = false;

	public Book() {

	}

	public Book(int no, String title, boolean isborrow) {
		super();
		this.no = no;
		this.title = title;
		this.isborrow = isborrow;
	}

	@Override
	public String toString() {
		if(isborrow == false) {
			return "책번호: "+ no + "책 제목: " + title + "대여상태: " + "입고중";
		}else {
			return "책번호: "+ no + "책 제목: " + title + "대여상태: " + "대여중";
		}
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isIsborrow() {
		return isborrow;
	}

	public void setIsborrow(boolean isborrow) {
		this.isborrow = isborrow;
	}

}
