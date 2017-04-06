package chap09.Class;

public class StringExample1 {
	public static void main(String[] args) {
		String str = "자바 커피";
		int len = str.length();
		for (int cnt = 0; cnt < len; cnt++) {
			char ch = str.charAt(cnt);
			System.out.println(ch);
		}
	}
}
