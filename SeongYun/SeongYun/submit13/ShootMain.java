package SeongYun.submit13;

public class ShootMain {

	public static void main(String[] args) {

		Shoot shooter1 = new Shoot("나", 0);
		Shoot shooter2 = new Shoot("너", 0);

		shooter1.doShoot();
		shooter1.doShoot();
		shooter1.doShoot();
		System.out.println(shooter1.getScore());
		System.out.println(shooter1);
		shooter2.doShoot();
		shooter2.doShoot();
		shooter2.doShoot();
		System.out.println(shooter2.getScore());
		System.out.println(shooter2);

		if (shooter1.getScore() > shooter2.getScore()) {
			System.out.println("1이 이겼다");
		} else if (shooter1.getScore() < shooter2.getScore()) {
			System.out.println("2가 이겼다");
		} else {
			System.out.println("비김");
		}

	}

}
