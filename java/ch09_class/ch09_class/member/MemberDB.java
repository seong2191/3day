package ch09_class.member;

import java.util.ArrayList;

public class MemberDB {
	private ArrayList<Member> memList;
	
	MemberDB(){
		memList = new ArrayList<Member>();
		Member temp = new Member("a001", "1234a", "석승원");
		memList.add(temp);
		memList.add(new Member("b001", "1234b", "김성빈"));
		memList.add(new Member("c001", "1234c", "염현섭"));
		memList.add(new Member("d001", "1234d", "김달현"));
	}
	
	public void regist(String id, String pw, String name) {
		memList.add(new Member(id, pw, name));
	}
	
	// 중복체크
	// 중복된다면 true 리턴
	public boolean checkDuple(String id) {
		for(int i = 0; i < memList.size(); i++) {
			if(memList.get(i).id.equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	// 로그인체크
	public boolean checkLogin(String id, String pw) {
		for(int i = 0; i < memList.size(); i++) {
			if(memList.get(i).id.equals(id)) {
				if(memList.get(i).pw.equals(pw)){
					return true;
				}
			}
		}
		return false;
	}
	// 회원목록 조회
	public void showMemList() {
		for(int i = 0; i < memList.size(); i++) {
			System.out.println(memList.get(i));
		}
	}
	

}
