import java.util.Scanner;

public class ArrayExample11 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int jumsu;
	
	System.out.println("정수 입력");
	jumsu = sc.nextInt();

	if (jumsu >= 90)
		System.out.println("수");
	else if (jumsu >= 80)
		System.out.println("우");
	else if (jumsu >= 70)
		System.out.println("미");
	else if (jumsu >= 60)
		System.out.println("양");
	else
		System.out.println("가");

	
//		if (jumsu >= 90)
//			System.out.println("수");
//		else if (jumsu >= 80)
//			System.out.println("우");
//		else if (jumsu >= 70)
//			System.out.println("미");
//		else if (jumsu >= 60)
//			System.out.println("양");
//		else
//			System.out.println("가");
	
}
}
