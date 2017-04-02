
public class ConditionalOrExample1 {
	public static void main(String[] args) {
		int num1 = 0, num2 = 0;
		if(++num1>0||++num2>0)
			System.out.println("num1이 0보다 크거나 num2가 0보다 큽니다");
		System.out.println("num1="+num1);
		System.out.println("num2="+num2);
	}
}
