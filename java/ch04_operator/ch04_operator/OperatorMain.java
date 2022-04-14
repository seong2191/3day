package ch04_operator;

public class OperatorMain {

	public static void main(String[] args) {
		
		int numTen = 10;
		
		System.out.println(numTen);
		
		//증감 연산자
		numTen++;		//1 증가
		System.out.println(numTen);
		numTen--;		//1 감소
		System.out.println(numTen);
		
		++numTen;		//1 증가
		System.out.println(numTen);		//numTen은 11
		
		System.out.println(numTen++);	//11
		System.out.println(numTen);		//12
		
		System.out.println(++numTen); 	//13
		
		
		System.out.println("\n===================================\n");
		
		char hangul = 44032;
		System.out.println(hangul++);
		System.out.println(hangul++);
		System.out.println(hangul++);
		System.out.println(hangul++);
		System.out.println(hangul++);
		
		
		// 대입 연산자
		numTen = 10;
		numTen+= 1;
		System.out.println(numTen);		//11
		
		numTen += 34;
		System.out.println(numTen);		//45
		
		numTen-= 20;
		System.out.println(numTen);		//25
		
		numTen*= 3;
		System.out.println(numTen);		//75
		
		numTen /= 5;
		System.out.println(numTen);		//15
		
		//나머지 연산
		numTen %= 4;
		System.out.println(numTen);		//3
		
		
		System.out.println("\n===================================\n");
		
		// 산술 연산자
		
		int numFirst = 10;
		int numSecond = 3;
		numFirst = numFirst + 1;
		System.out.println(numFirst);
		
		System.out.println("numFirst : 11, numSecond : 3");
		System.out.println("더하기: "+(numFirst + numSecond));
		System.out.println("빼기: "+(numFirst - numSecond));
		System.out.println("곱하기: "+(numFirst * numSecond));
		System.out.println("나누기: "+(numFirst / numSecond));		//정수와 정수의 나누기는 몫만 출력된다.
		System.out.println("나머지: "+(numFirst % numSecond));
		
		
		double temp = (double)numFirst / numSecond;		//방법1
		System.out.println(temp);
//		double temp = numFirst / (double)numSecond;		//방법2
		
		
		//먼저 계산할 부분에 괄호
		int numThird = 10 + (3 * 10);
		System.out.println(numThird);
		
		
		
		System.out.println("\n===================================\n");
		
		//나머지 연산자(%) 자주 쓰는 경우
		//홀수 짝수 판별
		int anyNum = 6;
		int remain = anyNum % 2;		//0 출력
		System.out.println(remain);
		
		//게시판 페이징 구현
		int totalCountGul = 33; // 게시판에 글이 총 33개 있다.
		int showCountOnePage = 10; // 한 페이지에서 보여줄 글의 개수가 10개
		
		//총 페이지의 수
		// 33 /10 = 3.3 -> 올림 = 4
		int countPage = (int)Math.ceil(((double)totalCountGul / showCountOnePage));
		System.out.println(countPage);
		// 마지막 페이지에 있는 글의 수
		int countLastPageGul = totalCountGul % showCountOnePage;
		
		
		System.out.println("총 게시글 수:" + totalCountGul);
		System.out.println("한 페이지당 보여줄 글의 수: "+showCountOnePage);
		System.out.println("총 페이지 수: "+ countPage);
		System.out.println("마지막 페이지에 있는 글의 수: "+ countLastPageGul);
		
		
		System.out.println("\n===================================\n");
		
		// 문자열 더하기
		String subway = "반석";
		subway = subway + ", 지족";
		
		System.out.println(subway);
		subway = "종점, "+ subway;
		System.out.println(subway);
		
		subway += ", 노은";
		System.out.println(subway); // 여기까지 결과 값 종점, 반석, 지족, 노은
		
		
		System.out.println("\n===================================\n");
		
		
		// 비교 연산자
		// 비교 연산자는 결과가 항상 true or false 인 논리값(boolean)이어야 한다.
		int numFive = 5;
		final double pi = 3.14; // 상수 
		int numOne = 1;
		
		boolean boolVal = numFive > numOne;
		System.out.println(boolVal);
		
		boolVal = numFive < pi;
		System.out.println(boolVal);
		
		System.out.println(10 >= 10);
		System.out.println(5 <= 15);
		
		System.out.println(10 == 11);
		System.out.println(5 != 10);
		
		// 문자열이 서로 같은지 비교
		
		String ship = "배";
		String pear = "배";
		String stomach = new String("배");
		
		System.out.println(ship == pear);
		System.out.println(ship == stomach);
		System.out.println(pear == stomach);

		
		// .equals(문자열)
		// 해당 문자열이 괄호 안 문자열과 같다면 true, 틀리면 false를 리턴
		System.out.println(ship.equals(stomach));
		
		
		String myMental = null;
		System.out.println(myMental == null);
		
		myMental = "";
		System.out.println(myMental.equals(""));
		System.out.println(myMental.length()==0);
		System.out.println(myMental.isEmpty());
		
		
		System.out.println("\n===================================\n");
		
		// 삼항 연산자 (조건 연산자)
		
		String stuMental = "100";
		String state = (stuMental.isEmpty()) ? "비었어요" : "들어있어요";
		System.out.println(state); // 비어있냐에 대한 물음을 state에 넣고 boolean 판단
		
		int stateNum = (stuMental.length()> 0) ? 100 : 0;
		System.out.println(stateNum);
		
		// 이중 삼항 연산자
		int score = 85;
		
		// score가 90점 보다 크면 grade는 A
		// 80점보다 크면 B
		// 나머지는 C
		String grade = (score > 90) ? "A" : ((score > 80) ? "B" : "C");
		System.out.println(grade);
		
		
		System.out.println("\n===================================\n");
		
		//논리 연산자
		
		myMental = "50";
		stuMental = "";
		
		// && 좌우 조건이 전부 참이어야만 true를 리턴
		// 둘 중 하나라도 거짓이면 false를 리턴
		System.out.println(myMental.isEmpty());
		System.out.println(stuMental.isEmpty());
		System.out.println(myMental.isEmpty() && stuMental.isEmpty());
		System.out.println(myMental.length() > 0 && stuMental.isEmpty());
		
		// || 좌우 조건 중 하나라도 참이라면 true
		// 둘 다 거짓이라면 false를 리턴
		System.out.println((myMental.isEmpty() || stuMental.isEmpty()));
		
		int numTwo = 2;
		int numThree = 3;
		int numFour = 4;
		
		// 2 < 3 < 4
		System.out.println((numTwo < numThree) && (numThree < numFour));
		
		// 회원가입 예시
		String name = "찬웅쌤";
		String phone = "01073987332";
		int age = 30;
		
		// name이 empty면 안되고
		// phone이 10자리 또는 11자리
		// age가 14이상이어야 함
		boolean checkName = name.length() > 0;
		boolean checkPhone = (phone.length () == 10) || (phone.length() == 11);
		boolean checkAge = age >= 14;
		
		System.out.println(checkName && checkPhone && checkAge);
		
		// !는 boolean(true/false)의 값을 뒤집는다.
		checkName = !name.isEmpty();
		System.out.println(checkName);
		
		System.out.println("\n===================================\n");
		
		// 비트 연산자
		int bitTen = 10; // 이진수로 1010
		int bitNine = 9; // 이진수로 1001
		
		// & AND
		System.out.println(bitTen & bitNine);
		// 8 -> 1000(이진수) 둘의 각 자리수가 둘다 1이어야 1로 변환, 하나라도 0이면 0
		
		
		// | OR
		System.out.println(bitTen | bitNine);
		//11 -> 1011(이진수) 둘의 각 자리수가 둘 중 하나가 1이면 1, 둘다 0이면 0
		
		
		// ^ XOR
		System.out.println(bitTen ^ bitNine);
		//3 -> 11(이진수) 둘의 각 자리수가 둘 중 하나가 1이면 리턴, 둘 다 0이면 출력안함
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
