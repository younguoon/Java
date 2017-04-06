package seongJeokHashMap;
import java.util.Iterator;
import java.util.LinkedList;

class LinkedListExample3 {
    public static void main(String args[]) {
        LinkedList<SeongJeok> list = new LinkedList<SeongJeok>();
        
        for (int i = 0; i < list.size(); i++) {
			SeongJeok obj = new SeongJeok();
			obj.input();
			obj.process();
			list.add(obj);
		}
        for(SeongJeok obj : list)
        	obj.output();
    }
}
