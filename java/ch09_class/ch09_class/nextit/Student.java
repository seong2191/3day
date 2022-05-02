package ch09_class.nextit;

public class Student {
	// 학생(Student) 클래스의 상태(State)를 필드 변수로 선언
	// 각각의 필드 변수의 값을 꼭 초기화(init)하지 않아도 된다.
	// name = "으음"
	String name = "이름없음";
	int age = 0;
	int level = 1;
	boolean isSubmit = false;

	// 기본 생성자(Constructor)
	// 클래스 내에 생성자를 따로 만들지 않는다면 생략된 상태로 존재한다.
	// 생성자를 따로 만들어줬다면, 아래 기본 생성자를 별도로 만들어야 사용 가능하다.
	// 생성자는 객체가 생성될 시 (new 클래스())
	// 실행되는 메소드라 봐도 무방
	Student() {
		this("이름없음", 0, 1);
		System.out.println("나 강림");
		this.level = 1;
	}

	// 이름과 나이만 입력받는 생성자
	Student(String name, int age) {
//		this.name = name;
//		this.age = age;
//		this.level = 1;		// 기본값 설정

		// 본인 생성자
		this(name, age, 1);
	}

	// 생성자
	// 단축키 [Alt + Shift + S] 또는
	// 마우스 우클릭 - Source
	// Generate Constructor using Fields
	Student(String name, int age, int level) {
		// this는 현재 객체(클래스)를 의미
		this.name = name;
		this.age = age;
		this.level = level;
	}
//	public Student(String name, int age, int level) {
//		super();
//		this.name = name;
//		this.age = age;
//		this.level = level;
//	}

	// 단축키 alt + shift + s
	// Generate toString()...
	// Override는 부모의 메소드를 자식 클래스에서 재정의 하는 것을 말한다.
	@Override
	public String toString() {
		return "이름 = " + name + "\n나이 = " + age + "\n레벨 = " + level + "\n과제제출 : " + isSubmit;
	}

	// 접근제어자
	// 기입하지 않은 경우 = default
	// 동일한 패키지 내에서만 사용이 가능
	// protected (= default)
	// private 현재 클래스 내에서만 사용이 가능
	// public 어디서나 사용 가능

	public void endDay() {
		levelUp();
	}

	private void levelUp() {
		int randInt = (int) (Math.random() * 5);
		level += randInt;
	}

	static void printInfo() {
		System.out.println("NextIt 훈련생입니다.");
	}

}
