
public class SmartExample {
	public static void main(String[] args) {
		int a = 3, b = 0;
		int result;
		try {
			result = a / b;
			System.out.println(result);
//			return;
		} catch (java.lang.Exception e) {
			System.out.println("�߸��� �����Դϴ�."+e.getMessage());
		} finally {
			System.out.println("Done.");
		}
	}
}
