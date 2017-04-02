import java.util.ArrayList;
import java.util.Scanner;

public class exam2 {
	public static void main(String[] args) {
		int num1, num2, min, max;
		int i, j;
		ArrayList<Integer> sosu = new ArrayList<Integer>();

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

		for (i = min; i <= max; i++) {
			for (j = 2; j < max; j++) {
				if (i % j == 0) {
					break;
				}
			}
			if (i == j) {
				sosu.add(i);
			}
		}

		for (int k = 0; k < sosu.size(); k++) {
			if (k % 10 == 0) {
				System.out.println();
			}
			System.out.printf("%3d",sosu.get(k));
		}
		System.out.println("\n");
		System.out.println("소수의 총 개수 : " + sosu.size());
	}
}
