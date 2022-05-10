package question;

import java.util.Scanner;

public class Question1 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		for (int i = 1; i <= 9; i++) {
			System.out.println(n + "*" + i + "=" + n * i);
		}

	}

}
