package SeongJeok;

public class SeongJeokEx01{
	final static int MAX = 100;
	int j = 0;
	public static void main(String[] args) {
		SeongJeok obj[] = new SeongJeok[MAX];
		PersonInfo obj1[] = new PersonInfo[MAX];

		input(obj, obj1);
		output(obj,obj1);
	}

//�����Է�, ���������Է� ����
	static int input(SeongJeok o1[], PersonInfo o2[]){
		int i, cnt=0;
		for (i = 0; i < MAX; i++) {
			System.out.println("*********���� �Է�*********\n");
			o1[i] = new SeongJeok();
			if(o1[i].input())
				break;
			o1[i].process();
			System.out.println();
			System.out.println("*********�������� �Է�*********\n");
			o2[i] = new PersonInfo();
			if(o2[i].input())
				break;
			System.out.println();
		}
		
		return cnt;
	}
	
//����, �������� ���
		static void output(SeongJeok o1[], PersonInfo o2[]){
			int i;
			
			//����
			System.out.println("\n           <<����>>");
			System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
			System.out.println("����    ����    ����     ����    ���              ���");
			for (i = 0; i < SeongJeok.stdCount; i++) {
				o1[i].output();
			}	
			System.out.printf("	     �л��� : %2d   ��ü��� : %2d ",SeongJeok.stdCount, SeongJeok.getTotalAvg());
			
			
			//��������
			System.out.println("\n\n          <<��������>>");
			System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
			System.out.println(" �й�               �̸�           �޴�����ȣ   �ּ�");
			for (i = 0; i < PersonInfo.infoCount; i++) {
				o2[i].output();
			}	
		}
	
	
		
		
		
		
		
		
//-------------------------------------------------------------------------------------
		
		
		
//�����Է�
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
	
//���� ���
	static void outputSeongJeok(SeongJeok o[]){
		int i;
		for (i = 0; i < SeongJeok.stdCount; i++) {
			o[i].output();
		}	
	}

//�������� �Է�
	static int inputPersonInfo(PersonInfo o[]){
		int i, cnt=0;
		
		for (i = 0; i < MAX; i++) {
			o[i] = new PersonInfo();
			if(o[i].input())
				break;
			System.out.println();
		}
		return cnt;
	}

//�������� ���
	static void outputPersonInfo(PersonInfo o[]){
		int i;
		for (i = 0; i < PersonInfo.infoCount; i++) {
			o[i].output();
		}	
	}
}
