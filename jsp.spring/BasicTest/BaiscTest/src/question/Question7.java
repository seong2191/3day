package question;


public class Question7 {

	public static void main(String[] args) {
		System.out.println(fibonachi(7));   //13
		System.out.println(fibonachi(8));   //21이 나오도록 fibonachi수열을 만드세요
	}
	static int fibonachi(int n) {
		if(n <= 1) {
			return n;
		}
		return fibonachi(n-1) + fibonachi(n-2);
	}
	
}
