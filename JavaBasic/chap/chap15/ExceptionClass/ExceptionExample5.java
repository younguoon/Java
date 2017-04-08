package chap15.ExceptionClass;

public class ExceptionExample5 {
	public static void main(String[] args) {
		int num1 = 2, num2 = 0;
		try {
			int result = num1 / num2;
			System.out.println(result);

		} catch (ArithmeticException e) {
			String str = e.getMessage();
			System.out.println(str);
		}
	}
}