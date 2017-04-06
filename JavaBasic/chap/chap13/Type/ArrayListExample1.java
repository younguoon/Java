package chap13.Type;

import java.util.ArrayList;

public class ArrayListExample1 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Æ÷µµ");
		list.add("µþ±â");
		list.add("º¹¼þ¾Æ");
		int num=list.size();
		for (int i = 0; i < num; i++) {
			String str = list.get(i);
			System.out.println(str);
			
		}
	}
}
