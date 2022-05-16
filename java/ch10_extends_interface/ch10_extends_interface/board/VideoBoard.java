package ch10_extends_interface.board;

public class VideoBoard extends Board{
	private String link;

	public VideoBoard() {
		super();
	}

	public VideoBoard(String category, String author, int no, String title, String content, String reple, String link) {
		super(category, author, no, title, content, reple);
		this.link = link;
	}

	@Override
	public String toString() {
		return super.toString() + "[link=" + link + "]";
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	
	
	
	

}
