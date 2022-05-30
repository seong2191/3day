package SeongYun.submit15.model;

public class TextLookVO {

	private int no;
	private String title;
	private String content;
	private String author;
	private String time;

	public TextLookVO() {

	}

	public TextLookVO(int no, String title, String content, String author, String time) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.author = author;
		this.time = time;
	}

	@Override
	public String toString() {
		return "TextVO [no=" + no + ", title=" + title + ", content=" + content + ", author=" + author + ", time="
				+ time + "]";
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
