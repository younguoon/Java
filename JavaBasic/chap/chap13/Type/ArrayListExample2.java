package chap13.Type;

import java.util.ArrayList;

public class ArrayListExample2 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add(2,"AA");
		list.set(0, "BB");
		list.remove(1);
		list.remove("C");
		int num = list.size();
		for (int i = 0; i < num; i++) {
			String str = list.get(i);
			System.out.println(str);
			
		}
	}
}
