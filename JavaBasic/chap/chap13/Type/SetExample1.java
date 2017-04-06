package chap13.Type;

import java.util.HashSet;
import java.util.Iterator;

public class SetExample1 {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("자바");
		set.add("카푸치노");
		set.add("에스프레소");
		set.add("자바");
		
		set.add("카푸치노1");
		set.add("에스프레소1");
		set.add("자바1");
		
		set.add("카푸치노2");
		set.add("에스프레소2");
		set.add("자바2");
		
		System.out.println("저장된 데이터의 수 : "+set.size());
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()){
			String str = iterator.next();
			System.out.println(str);
		}
	}
}
