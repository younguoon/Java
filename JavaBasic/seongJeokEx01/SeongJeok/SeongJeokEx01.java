package SeongJeok;

public class SeongJeokEx01 {
	final static int MAX = 1000;
	public static void main(String[] args) {
		SeongJeok obj[] = new SeongJeok[MAX];
		
		inputSeongJeok(obj);

		System.out.println("\n               ***����ǥ***");
		System.out.println("================================================");
		System.out.println("\n�й�      �̸�      ����    ����    ����     ����    ���     ���");
		System.out.println("================================================");
		outputSeongJeok(obj);
		System.out.println("================================================");
		System.out.printf("		�л� �� : %3d 	��ü ��� : %3d ",SeongJeok.stdCount, SeongJeok.getTotalAvg());
		//�����޼ҵ�(��ü���), �����ʵ� �ΰ�(�հ贩��, �л��� ī��Ʈ) �����հ�, ��ü���, ��ü �л� ��
	}

	static int inputSeongJeok(SeongJeok o[]){
		int i, cnt=0;
		
		for (i = 0; i < MAX; i++) {
			o[i] = new SeongJeok();
			if(o[i].input())
				break;
			o[i].process();
			System.out.println();
		}
		return cnt;
	}
	
	static void outputSeongJeok(SeongJeok o[]){
		int i;
		for (i = 0; i < SeongJeok.stdCount; i++) {
			o[i].output();
		}	
	}
}
