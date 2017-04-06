package chap09.Class.Calculator;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Calculator {
	static String All;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력");
		All = sc.next();
		calculate();
	}

	public static void calculate() {
		StringTokenizer All_token = new StringTokenizer(All, "+-*/=", true);
		String[] token_array = new String[All_token.countTokens()];

		for (int i = 0; i < token_array.length; i++) {
			while (All_token.hasMoreTokens()) {
				token_array[i++] = All_token.nextToken();
			}
		}
		
		for (int i = 0; i < token_array.length; i++) {
			System.out.println(token_array[i]);
		}
	}
	
	public static boolean check(){
		
		return false;
	}
}


