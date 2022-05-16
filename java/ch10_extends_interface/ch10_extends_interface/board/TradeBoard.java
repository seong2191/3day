package ch10_extends_interface.board;

public class TradeBoard extends Board {

	private int price;
	private String image;

	public TradeBoard() {
		super();
	}

	public TradeBoard(String category, String author, int no, String title, String content, String reple, int price, String image) {
		super(category, author, no, title, content, reple);
		this.price = price;
		this.image = image;
	}

	@Override
	public String toString() {
		return super.toString() + "[price=" + price + ", image=" + image + "]";
	}

	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	

}
