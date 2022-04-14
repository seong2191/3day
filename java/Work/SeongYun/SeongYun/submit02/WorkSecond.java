package SeongYun.submit02;
import java.util.Scanner;

public class WorkSecond {
	

	public static void main(String[] args) {
		
		Scanner score = new Scanner(System.in);
		
		System.out.print("이름을 입력해주세요");
		System.out.print(": ");
		String name = score.nextLine();
		
		
		System.out.print("국어 점수를 입력해주세요");
		System.out.print(": ");
		String kor = score.nextLine();
		
		System.out.print("영어 점수를 입력해주세요");
		System.out.print(": ");
		String eng = score.nextLine();
		
		System.out.print("수학 점수를 입력해주세요");
		System.out.print(": ");
		String math = score.nextLine();
		
		int plus= Integer.parseInt(kor);
		int plus1= Integer.parseInt(eng);
		int plus2= Integer.parseInt(math);
		double avg = ((double)plus+plus1+plus2)/3;
		
	
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
		
		String idBackGen = (idBackInt % 2 ==0) ? "여성" : "남성";
		System.out.println(idBackGen);
	}

}
