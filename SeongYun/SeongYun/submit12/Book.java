package SeongYun.submit12;

public class Book {
	private int no;				// 책 번호
	private String name; 		// 책 제목
	private boolean isBorrow;	// 책 대여여부 (true면 대여중, false면 입고중)
	
	public Book() {}
	
	public Book(int no, String name) {
		this.no = no;
		this.name = name;
	}
	
	public Book(int no, String name, boolean isBorrow) {
		this.no = no;
		this.name = name;
		this.isBorrow = isBorrow;
	}
	
	@Override
	public String toString() {
		String state = "입고중";
		if(isBorrow) {
			state = "대여중";
		}
		return "[책번호: " + no + ", 책 제목: " + name + ", 대여상태: " + state + "]";
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isBorrow() {
		return isBorrow;
	}
	public void setBorrow(boolean isBorrow) {
		this.isBorrow = isBorrow;
	}
	
}