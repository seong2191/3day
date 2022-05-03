package ch09_class.homepage;

import java.util.ArrayList;

public class BoardDB {
	private ArrayList<Board> boardList = new ArrayList<>();
	
	// 싱글톤 패턴 적용
	// 객체를 딱 한번만 소환할거임
	// 1. 기본 생성자를 private로 막는다.
	private BoardDB() {
	}
	
	// 2. 필드에 BoardDB를 new를 이용해서 객체(instance)로 만들어 둔다.
	private static BoardDB instance = new BoardDB();
	
	// 3. 객체로 만든 instance를 제공하는 함수(Getter) 만들기
	public static BoardDB getInstance() {
		return instance;
	}
	
	// 글 작성
	public void write(String title, String content, String author) {
		boardList.add(new Board(boardList.size()+1, title, content, author));
	}
	
	// 게시글 목록 출력
	public void printBoards() {
		for(int i = 0 ; i < boardList.size(); i++) {
			System.out.println(boardList.get(i));
		}
	}
	
	// 게시글 조회(클릭한거)
	public boolean selectBoard(int no) {
		for(int i = 0; i < boardList.size(); i++) {
			if(boardList.get(i).getNo() == no) {
				System.out.println("제목: " + boardList.get(i).getTitle());
				System.out.println("작성자: " + boardList.get(i).getAuthor());
				System.out.println("내용: " + boardList.get(i).getContent());
				return true;
			}
		}
		return false;
	}

}
