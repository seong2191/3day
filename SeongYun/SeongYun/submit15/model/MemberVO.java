package SeongYun.submit15.model;

public class MemberVO {

	private String memId;
	private String memPassword;

	public MemberVO() {

	}

	public MemberVO(String memId, String memPassword) {
		super();
		this.memId = memId;
		this.memPassword = memPassword;
	}

	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memPassword=" + memPassword + "]";
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPassword() {
		return memPassword;
	}

	public void setMemPassword(String memPassword) {
		this.memPassword = memPassword;
	}

}
