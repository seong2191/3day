package ch11_java_api;

public class ApiStringBuffer {

	public static void main(String[] args) {

		// 문자열하면? String
		// String을 계속 수정하게 되면
		// 힙 메모리 영역에 매번 새로운 String 객체가 만들어지고,
		// 그로 인해 가비지 컬렉터가 할 일이 많아진다.
		// = 비효율적

		// 랜덤숫자 10자리를 더한다
		String strVal = "";
		for (int i = 0; i < 10; i++) {
			// 0~9 랜덤 수
			int randInt = (int) (Math.random() * 10);
			strVal += randInt;
		}
		System.out.println(strVal);

		System.out.println("\n================================\n");

		// StringBuffer
		StringBuffer strBuff = new StringBuffer();
		System.out.println(strBuff);

		// 문자열 추가
		strBuff.append("안녕");
		System.out.println(strBuff);
		strBuff.append("하세요");
		System.out.println(strBuff);

		// StringBuffer가 가진 문자열을 String으로 꺼내올 일이 상당히 많다.
		String str = strBuff.toString();
		System.out.println(str);

		System.out.println("\n================================\n");

		// StringBuilder (구조는 StringBuffer 와 같다)
		StringBuilder strBuild = new StringBuilder();

		strBuild.append("안녕히");
		System.out.println(strBuild);
		strBuild.append("가세요");
		System.out.println(strBuild);

		String strB = strBuff.toString();
		System.out.println(strB);

		// 둘의 차이점
		// StringBuffer는 동기화 지원
		// StringBuilder는 동기화 미지원

		// 동기화란 멀티쓰레드 환경에서 해당 객체가 모든 쓰레드에서 안정적으로
		// 사용 가능하도록 하는 것

		// 동기화 미지원 (StringBuilder)
		// 쓰레드 a, b, c에서 strBuild 를 사용한다면
		// 쓰레드 a에서 strBuild 객체의 값을 바꿨을때
		// 스레드 b, c에서 이를 모른다.
		// 단일 쓰레드에서는 좋은 성능을 가진다.

		// 동기화 지원(StringBuffer)
		// 쓰레드 a, b, c에서 strBuff를 사용한다면
		// 쓰레드 a에서 strBuff 객체의 값을 바꿨을때
		// 쓰레드 b, c에서 이를 안다.
		// 단일 쓰레드에서 느린 성능

	}

}
