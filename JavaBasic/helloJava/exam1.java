import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class exam1 {
	public static void main(String[] args) {
		int num1, num2, min, max;
		int gugu[];

		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);

		System.out.print("ù��° ���� �Է� :");
		num1 = sc1.nextInt();
		System.out.print("�ι�° ���� �Է� :");
		num2 = sc2.nextInt();

		if (num1 < num2) {
			min = num1;
			max = num2;
		} else {
			min = num2;
			max = num1;
		}
		
		
//���� ���		
		for (int i = min; i <= max; i++) {
			System.out.print("***" + i + "��***        ");
		}
		System.out.println();

		for (int j = 1; j <= 9; j++) {
			for (int i = min; i <= max; i++) {
//				System.out.print(i + " * " + j + " = " + (i * j)+"      ");
				System.out.printf("%d * %d = %2d      ",i,j,i*j);
			}
			System.out.println();
		}

//���� ���
		/*
		 * for (int i = min; i <= max; i++) { System.out.println("***" + i +
		 * "��***"); for (int j = 1; j <= 9; j++) { System.out.println(i + " * "
		 * + j + " = " + (i * j)); } System.out.println(); }
		 */
	}
}
