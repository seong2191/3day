package question;

public class Question3 {
	public static void main(String[] args) {

		String star = "";

		for (int i = 0; i < 5; i++) {
			star += "*";
			System.out.println(star);
		}
		
		for(int i = 1; i<= 5; i++) {
			for(int j = 5; j > 0 ; j--) {
				if(j>i) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		
		
		String star2 = "*";
		for(int i = 0; i< 5; i++) {
			String blank = "";
			for(int j = 0; j < 4-i; j++) {
				blank += " ";
			}
			System.out.println(blank + star2);
			star2 += "**";
		}

	}
}
