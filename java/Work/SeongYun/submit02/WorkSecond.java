package SeongYun.submit02;
import java.util.Scanner;

public class WorkSecond {
	

	public static void main(String[] args) {
		
		// 사용자로부터 이름, 국어, 영어, 수학 점수를 입력받고
		// 평균45.0을 포함해서 콘솔창에 출력
		
		Scanner score = new Scanner(System.in);
		
		System.out.println("이름을 입력해주세요");
		System.out.print(": ");
		String name = score.nextLine();
		
		
		System.out.print("국어 점수를 입력해주세요");
		System.out.println(": ");
		String kor = score.nextLine();
//		int plus = Integer.parseInt(score.nextLine());
		
		System.out.println("영어 점수를 입력해주세요");
		System.out.print(": ");
		String eng = score.nextLine();
//		int plus1 = Integer.parseInt(score.nextLine());
		
		System.out.println("수학 점수를 입력해주세요");
		System.out.print(": ");
		String math = score.nextLine();
//		int plus2 = Integer.parseInt(score.nextLine());
		
		int plus= Integer.parseInt(kor);
		int plus1= Integer.parseInt(eng);
		int plus2= Integer.parseInt(math);
		double avg = ((double)plus+plus1+plus2)/3;
//		double avg = (plus+plus1+plus2)/3.0;
		
	
		System.out.println("\n================================\n");
		
		System.out.println("이름: "+name);
		System.out.println("국어: "+kor);
		System.out.println("영어: "+eng);
		System.out.println("수학: "+math);
		System.out.println("평균: "+avg);
		
		
		System.out.println("\n================================\n");
		
		
		
		String idBack = "12231476";
		
		System.out.println(idBack.substring(0,1));
		
		int idBackInt = Integer.parseInt(idBack.substring(0,1));
		System.out.println(idBackInt);
		
		String idBackGen = (idBackInt % 2 ==1) ? "남성" : "여성";
		// idBackInt = 1, 1을 2로 나눈 나머지가 1이다. 맞으면 홀수 아니면 짝수(true : false)
		System.out.println(idBackGen);
		
		
	}

}
