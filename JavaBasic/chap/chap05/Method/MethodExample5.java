package chap05.Method;

public class MethodExample5 {
	public static void main(String[] args) {
		Account obj = new Account("77-77-77", "최대박", 10);
		try {
			int amount = obj.withdraw(1000);
			System.out.println("인출액 : " + amount);
		} catch (Exception e) {
			String msg = e.getMessage();
			System.out.println(msg);
		}
	}
}
