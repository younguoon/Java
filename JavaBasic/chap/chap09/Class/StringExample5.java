package chap09.Class;

public class StringExample5 {
	public static void main(String args[]) {
		String str1 = new String("자바");
		String str2 = new String("자바");
		if (str1.equals(str2))
			System.out.println("같음");
		else
			System.out.println("다름");
	}

}
