package ch02_variable;

public class VariableMain {

	public static void main(String[] args) {

		//변수의 선언
		
		//변수의 선언과 함께 값을 초기화 
		//Initialization = init
		int numOne = 1; 
		int numTwo;     // 변수의 선언
		numTwo = 2;     // 초기화
		
		//변수의 다중 선언
		int numThree, numFour;
		numThree = 3;
		numFour = 4;
		
		//다중선언은 가능하지만 값을 넣어주면서 선언할 수는 없다.
		//단축키 [ctrl+/] 해당 커서 주석처리
//		int a, b, c = 4, 5, 6;
		
		
		System.out.println(numOne);
		
		//변수의 값 변경
		numOne = 10;
		System.out.println(numOne);
		
		
		//상수의 선언
		final double MATH_PI = 3.141592;
		System.out.println(MATH_PI);
		
		//콘솔창 줄 바꾸고 구역나누는 팁
		System.out.println("\n=============================\n");
		
		//문자열 String
		//문자열은 클래스이므로, 다양한 Method(함수)를 내장하고 있다.
		//문자열은 쌍따옴표("") 안에 문자들을 말한다.
		//'가'는 char 타입이므로, "가" 문자열과 타입이 다르다.
		String fruits = "Apple, Banana, Cherry";
		System.out.println(fruits);
		
		
		// .Length()
		//해당 문자열의 길이를 리턴 (공백, 콤마, 점 포함 길이)
		System.out.println(fruits.length());
		System.out.println("abcde".length());
		
		
		// .charAt(인덱스)
		//인덱스는 배열, 문자열에서 몇 번째에 해당하는 숫자를 의미한다.
		//***인덱스는 0부터 시작(인덱스 0 = 첫번째)
		//해당 문자열에서 인덱스에 해당하는 문자(char)를 리턴한다.
		char alphaP = fruits.charAt(1);
		System.out.println(alphaP);
		System.out.println(fruits.charAt(1));
		
		
		// .indexOf(문자열)
		//해당 문자열에서 괄호 안에 있는 문자의 인덱스를 리턴.
		System.out.println(fruits.indexOf("Banana"));
		//문자 통째로 일치해야 하고, 해당 문자열을 포함하지 않는다면 -1을 리턴.
		System.out.println(fruits.indexOf("banana"));
		
		
		//변수를 사용하는 이유
		//수정이 용이하다.
		
		
		//콘솔창에 10을 10번 출력
		System.out.println(10);
		System.out.println(10);
		System.out.println(10);
		System.out.println(10);
		System.out.println(10);
		System.out.println(10);
		System.out.println(10);
		System.out.println(10);
		System.out.println(10);
		System.out.println(10);
		
		//콘솔창에 11을 10번 출력
		
		int temp = 11;
		System.out.println(temp);
		System.out.println(temp);
		System.out.println(temp);
		System.out.println(temp);
		System.out.println(temp);
		System.out.println(temp);
		System.out.println(temp);
		System.out.println(temp);
		System.out.println(temp);
		System.out.println(temp);
		
		//변수를 사용하는 이유
		int myAge = 27;
		System.out.println(myAge);
		 
		//값에 이름을 부여할 수 있다.
		
		
		// .substring(시작 인덱스, 끝 인덱스)
		// 해당 문자열을 시작 인덱스에서 끝 인덱스 전까지 자른다. (끝 인덱스는 포함되지 않는다.)
		System.out.println(fruits.substring(0, 5));
		// 괄호 안에 시작 인덱스 하나만 넣는다면 해당 문자열을 시작 인덱스부터 끝까지
		int cherryIndex = fruits.indexOf("Cherry");
		System.out.println(fruits.substring(cherryIndex));
		
		System.out.println(fruits.substring(fruits.indexOf("Banana")));
		System.out.println(fruits.substring(fruits.indexOf("Apple")));
		

		
		// .replace(바뀔 문자열, 바꾸고 싶은 문자열)
		// 해당 문자열에서 바뀔 문자열을 바꾸고 싶은 문자열로 교체
		System.out.println(fruits.replace("Cherry", "Coconut"));
		// String 객체의 Method 실행 시 원본은 변하지 않는다.(원래 선언된 변수는 바뀌지 않는다.)
		System.out.println(fruits);
		
		
		// .trim()
		// 해당 문자열의 양 끝에 존재하는 모든 공백문자를 제거해준다.
		String world = "    Ronaldo siiiii !! ";
		System.out.println(world.replace(" ", ""));
		System.out.println(world.trim());
		
		
		// .toUpperCase()
		// .toLowerCase()
		// 해당 문자열에 존재하는 알파벳들을 전부 대문자(어퍼케이스)/소문자(로어케이스)로 바꿔준다.
		System.out.println(fruits.toUpperCase());
		System.out.println(fruits.toLowerCase());
		
		
		// .concat(문자열)
		// 해당 문자열에 뒤에 괄호 안에 있는 문자열을 붙인다.
		System.out.println(fruits.concat(", Durian"));
		System.out.println(fruits + ", Durian");
		
		
		fruits = fruits + ", Durian";
		System.out.println(fruits);
		
		
		System.out.println("\n===============================================\n");
		
		// String은 참조 타입이므로 null 값을 가질 수 있다.
		// 참조 타입의 변수를 객체 또는 인스턴스라고 부른다.
		String nothing = ""; //띄어쓰기 없는 빈 값을 empty라 부른다.
		System.out.println(nothing);
		
		String nullthing = null;
//		System.out.println(nullthing.concat("말")); // null 영역이라 실행 에러
		
		System.out.println("\n============================================\n");
		
		// 문자(char)
		// 작은 따옴표('') 안에 한 문자를 담을 수 있으며 숫자 또한 담을 수 있다.
		// 이때 숫자는 유니코드에 등록된 각 문자들에 대한 넘버링이다.
		char wordA = 'A';
		System.out.println(wordA);
		char numA = 65;
		System.out.println(numA);
		
		char hangeul = 44034;
		System.out.println(hangeul);
		
		// byte는 -128부터 127까지만 담을 수 있다.
		byte byteNum = 127;
		byteNum++;     // 1을 더한다.
		byteNum += 2;  // 2를 더한다.
		System.out.println(byteNum);
		
		
		System.out.println("\n============================================\n");
		
		// 형 변환(Casting)
		// 형 변환이 가능한 경우에는 형 변환을 이용해서 상황에 맞게 적절히 사용할 수 있다.
		int intVal = 15;
		double doubVal = 1.23;
		
		// int 곱하기 double은 double 타입으로 자동으로 형 변환이 된다.
		System.out.println(intVal * doubVal);
		double mulResult = intVal * doubVal;
		
		// int 곱하기 float을 해도 float으로 자동 형 변환이 된다.
		float floatRslt = intVal * 2.34f;
		
		// int 20000이 long으로 자동 형 변환되어 담긴다.
		long longVar = 20000000000l;
		
		// int 더하기(+) 문자열(String)을 더하면 int가 문자열로 자동 형변환이 된다.
		// 문자열 더하기(이어붙이기)가 된다.
		String CountStar = "비오";
		String addCountStar = CountStar + 100;
		System.out.println(addCountStar);
		
		
		System.out.println("\n=================================\n");
		
		// 강제 형 변환
		// (타입) 값을 이용하여 값을 해당 타입으로 강제 형 변환 할 수 있다.
		float floatNum = (float) (10 * 3.14);
		
		
		// 가장 많이 하는 실수
		double result = 10 / 3; //3.333이 나와야 하는데 왜 3이 나오나?(인트끼리 연산이 되어 인트만 출력이 되었다.)
		System.out.println(result);
		
		double doubleresult = 10.0 / 3.0; // (소수점을 붙여 더블형태로 만들었다.)
		System.out.println(doubleresult);
		
		// 숫자 문자열과 숫자 간의 형 변환 (숫자로 이루어진 문자열은 연산이 불가능하다.)
		String strNum = "123";
		System.out.println(strNum + 2);
		
		// **문자열을 정수로 형 변환
		// Integer.parseInt(숫자 문자열)
		int intNum = Integer.parseInt(strNum);
		System.out.println(intNum + 2);
		
		// **정수를 문자열로 형 변환
//		String strNumCast = Integer.toString(intNum);
		String strNumCast = intNum + "";
		System.out.println(strNumCast + 2);
		
		// 실수 문자열을 실수로 형 변환
		strNum = "50.23";
		double doubNum = Double.parseDouble(strNum);
		System.out.println(doubNum + 5);
		
		
		
	}

}
