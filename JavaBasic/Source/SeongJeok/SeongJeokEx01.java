package SeongJeok;

import java.util.ArrayList;

public class SeongJeokEx01{
	final static int MAX = 100;
	int j = 0;
	static SeongJeok grade = new SeongJeok();
	static PersonInfo pInfo = new PersonInfo();
	
	public static void main(String[] args) {
		SeongJeok obj[] = new SeongJeok[MAX];
		PersonInfo obj1[] = new PersonInfo[MAX];
		
//		input(obj, obj1);
//		output(obj,obj1);
		
		ArrayList<SeongJeok> list = new ArrayList<SeongJeok>();
		inputSeongJeok1(list);
		System.out.println("\n           <<����>>");
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		System.out.println("����    ����    ����     ����    ���              ���");
		outputSeongJeok1(list);
		System.out.printf("\n	     �л��� : %2d   ��ü��� : %5d ",SeongJeok.stdCount, SeongJeok.getTotalAvg());
		}


// Ver.ArrayList
//�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�

		//�����Է�
		static void inputSeongJeok1(ArrayList<SeongJeok> list){
			SeongJeok obj = null;
			while(true){
				obj = new SeongJeok();
				if(obj.input())
					break;
				obj.process();
				list.add(obj);
				System.out.println();
			}
		}	
		
		//���� ���
		static void outputSeongJeok1(ArrayList<SeongJeok> list){
			int i;
			SeongJeok obj = null;
			for(i=0; i<list.size(); i++){
				obj=list.get(i);
				obj.output();
			}
		}
		

//�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�	


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
			int i, cnt=0;;
			
			
			//����
			System.out.println("\n           <<����>>");
			System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
			System.out.println("����    ����    ����     ����    ���              ���");
			for (i = 0; i < grade.gradeList.size(); i++) {
				System.out.print(grade.gradeList.get(i)+"    ");
				if(cnt%5==0){
					System.out.println();
				}
				cnt++;
				
			}
			
//			for (i = 0; i < SeongJeok.stdCount; i++) {
//				o1[i].output();
//			}
			System.out.printf("\n	     �л��� : %2d   ��ü��� : %2d ",SeongJeok.stdCount, SeongJeok.getTotalAvg());
			
			
			//��������
			System.out.println("\n\n          <<��������>>");
			System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
			System.out.println(" �й�               �̸�           �޴�����ȣ   �ּ�");
			for (i = 0; i < pInfo.personList.size(); i++) {
				System.out.print(pInfo.personList.get(i)+"   ");
			}
//			for (i = 0; i < PersonInfo.infoCount; i++) {
//				o2[i].output();
//			}	
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
