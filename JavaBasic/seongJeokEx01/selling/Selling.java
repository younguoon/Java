package selling;
import java.util.Scanner;

public class Selling {
	int prdCount, prdPrice,prdSellingPrice;
	String prdName, prdCode;
	static int prdTotalPrice=0;
	
	public Selling(){
		
	}
	

	public Selling(int prdCount, int prdPrice, int prdSellingPrice, String prdName, String prdCode) {
		super();
		this.prdCount = prdCount;
		this.prdPrice = prdPrice;
		this.prdSellingPrice = prdSellingPrice;
		this.prdName = prdName;
		this.prdCode = prdCode;
	}

	boolean input(){
		Scanner sc = new Scanner(System.in);
		System.out.print("제품코드 입력 : ");
		prdCode = sc.next();
		if (prdCode.toLowerCase().equals("quit")) 
			return true;
		System.out.print("제품명 입력 : ");
		prdName = sc.next();
		System.out.print("단가 입력 : ");
		prdPrice = sc.nextInt();
		System.out.print("수량 입력 : ");
		prdCount = sc.nextInt();
		return false;
	}
	
	void process(){
		prdSellingPrice = prdPrice*prdCount;
		prdTotalPrice += prdSellingPrice;
	}
	
	void output(){  
		System.out.printf("%4s	%3s	%3d	%3d	%3d	\n", 
						   prdCode, prdName, prdPrice, prdCount, prdSellingPrice);
	}

	public static int getprdTotalPrice() {
		return prdTotalPrice;
	}
	
}
