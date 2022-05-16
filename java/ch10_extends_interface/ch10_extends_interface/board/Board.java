package ch10_extends_interface.board;

public class Board {
	private String category;
	private String author;
	private int no;
	private String title;
	private String content;
	private String reple;
	
	
	public Board() {
		
	}
	
	public Board(String category, String author, int no, String title, String content, String reple) {
		super();
		this.category = category;
		this.author = author;
		this.no = no;
		this.title = title;
		this.content = content;
		this.reple = reple;
	}

	@Override
	public String toString() {
		return "Board [category=" + category + ", author=" + author + ", no=" + no + ", title=" + title + ", content="
				+ content + ", reple=" + reple + "]";
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReple() {
		return reple;
	}

	public void setReple(String reple) {
		this.reple = reple;
	}
	
	
	
	
	
	

}
