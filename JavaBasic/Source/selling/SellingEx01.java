package selling;

import java.util.ArrayList;

public class SellingEx01 {
	final static int MAX = 1000;
	public static void main(String[] args) {
		Selling obj[] = new Selling[MAX];
		ArrayList<Selling> list = new ArrayList<Selling>();
		int cnt;
		
//		cnt=inputSelling(obj);
		input(list);
		System.out.println("\n               ***�Ǹ���Ȳ***");
		System.out.println("================================================");
		System.out.println("\n��ǰ�ڵ�	��ǰ��	�ܰ�	����	�ݾ�");
//		outputSelling(obj, cnt);
		output(list);
		System.out.println("================================================");
		System.out.printf("�� �Ǹűݾ� : %3d ",Selling.getprdTotalPrice());
	}
	

// Ver.List ��
//�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�
	static int input(ArrayList<Selling> list){
		int cnt=0;
		Selling obj = null;
		while(true){
			obj = new Selling();
			if(obj.input())
				break;
			obj.process();
			list.add(obj);
			cnt++;
			System.out.println();
		}
		return cnt;
	}
	
	static void output(ArrayList<Selling> list){
		Selling obj = null;
		for (int i = 0; i < list.size(); i++) {
			obj=list.get(i);
			obj.output();
		}
	}
	
// Ver.List ��
//�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�	
	static int inputSelling(Selling obj[]){
		int i=0, cnt=0;
		for (i = 0; i < MAX; i++) {
			obj[i] = new Selling();
			if(obj[i].input())
				break;
			obj[i].process();
			cnt++;
			System.out.println();
		}
		return cnt;
	}
	
	static void outputSelling(Selling obj[], int cnt){
		int i;
		for (i = 0; i < cnt; i++) {
			obj[i].output();
		}
	}
}
