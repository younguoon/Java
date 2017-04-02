import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class exam1 {
	public static void main(String[] args) {
		int num1, num2, min, max;
		int gugu[];

		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);

		System.out.print("첫번째 숫자 입력 :");
		num1 = sc1.nextInt();
		System.out.print("두번째 숫자 입력 :");
		num2 = sc2.nextInt();

		if (num1 < num2) {
			min = num1;
			max = num2;
		} else {
			min = num2;
			max = num1;
		}
		
		
//가로 출력		
		for (int i = min; i <= max; i++) {
			System.out.print("***" + i + "단***        ");
		}
		System.out.println();

		for (int j = 1; j <= 9; j++) {
			for (int i = min; i <= max; i++) {
//				System.out.print(i + " * " + j + " = " + (i * j)+"      ");
				System.out.printf("%d * %d = %2d      ",i,j,i*j);
			}
			System.out.println();
		}

//세로 출력
		/*
		 * for (int i = min; i <= max; i++) { System.out.println("***" + i +
		 * "단***"); for (int j = 1; j <= 9; j++) { System.out.println(i + " * "
		 * + j + " = " + (i * j)); } System.out.println(); }
		 */
	}
}
