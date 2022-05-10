package SeongYun.submit13;

public class Shoot {
	
	private String name;
	private int score;
	
	public Shoot(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	
	
	public void doShoot() {
		int randInt = (int)(Math.random()*10)+1;
		System.out.println(randInt);
		this.score += randInt;
	}
	
	@Override
	public String toString() {
		return "선수이름: " + name + " 총 점수: " + score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
	

}
