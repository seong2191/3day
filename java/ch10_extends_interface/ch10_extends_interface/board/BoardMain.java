package ch10_extends_interface.board;

public class BoardMain {

	public static void main(String[] args) {
		
		Board basic = new Board("구인", "넥스트IT", 1, "ㅎㅇ", "ㅎㅇㅎㅇ", "ㅋㅋ");
		System.out.println(basic);
		
		// 거래 게시판
		TradeBoard trade = new TradeBoard("팝니다", "일반인", 1, "다 팝니다", " 이걸 팝니다", " 뭘 파나요", 5000, "몰루");
		System.out.println(trade);
		
		// 영상 게시판
		VideoBoard video = new VideoBoard("영화", "나", 1, "액션스릴러", "슈웅", "몰루", "www.youtube.com");
		System.out.println(video);

	}

}
