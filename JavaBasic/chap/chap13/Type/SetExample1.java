package chap13.Type;

import java.util.HashSet;
import java.util.Iterator;

public class SetExample1 {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("�ڹ�");
		set.add("īǪġ��");
		set.add("����������");
		set.add("�ڹ�");
		
		set.add("īǪġ��1");
		set.add("����������1");
		set.add("�ڹ�1");
		
		set.add("īǪġ��2");
		set.add("����������2");
		set.add("�ڹ�2");
		
		System.out.println("����� �������� �� : "+set.size());
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()){
			String str = iterator.next();
			System.out.println(str);
		}
	}
}
