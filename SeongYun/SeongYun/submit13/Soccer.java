package SeongYun.submit13;

public class Soccer {

	private int no;		
	private String name; 
	
	public Soccer() {}
	
	public Soccer(int no, String name) {
		this.no = no;
		this.name = name;
	}

	@Override
	public String toString() {
		return "번호: " + no + " 선수이름: " + name;
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
}
