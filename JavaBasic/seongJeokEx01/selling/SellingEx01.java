package selling;

public class SellingEx01 {
	final static int MAX = 1000;
	public static void main(String[] args) {
		Selling obj[] = new Selling[MAX];
		int cnt;
		
		cnt=inputSelling(obj);
		
		System.out.println("\n               ***�Ǹ���Ȳ***");
		System.out.println("================================================");
		System.out.println("\n��ǰ�ڵ�	��ǰ��	�ܰ�	����	�ݾ�");
		outputSelling(obj, cnt);
		System.out.println("================================================");
		System.out.printf("�� �Ǹűݾ� : %3d ",Selling.getprdTotalPrice());
	}
	
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
