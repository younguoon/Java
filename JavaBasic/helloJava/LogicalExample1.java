
public class LogicalExample1 {
	public static void main(String[] args) {
		int a=3, b=4, c=3, d=5;
		if((a==2|a==c)&!(c>d)&(1==b^c!=d))
			System.out.println("맞습니다.");
		else
			System.out.println("아닙니다");
	}
}
