package ch09_class.homepage;

public class Member {
	// 필드변수
	private String id;
	private String passWord;

	public Member(){
		
	}
	
	public Member(String id, String passWord) {
		super();
		this.id = id;
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "[아이디: " + id + " ]";
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

}
