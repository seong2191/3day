package SeongYun.submit14;

public class Board {
	int no;
	String title;
	String make;
	String body;

	public Board(int no, String title, String make, String body) {
		super();
		this.no = no;
		this.title = title;
		this.make = make;
		this.body = body;
	}

	@Override
	public String toString() {
		return "[" + (no + 1) + ". | " + title + " | " + make + "]";
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

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
