package chap09.Class;

import java.util.StringTokenizer;

public class StringTokenizerExample1 {
	public static void main(String[] args) {
		StringTokenizer stok = new StringTokenizer("��� �� ������", ",");
		while(stok.hasMoreTokens()){
			String str = stok.nextToken();
			System.out.println(str);
		}
	}
}
