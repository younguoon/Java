package seongJeokArrayList;
import java.util.ArrayList;
import java.util.Scanner;

public class SeongJeokArrayList {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<SeongJeok> seongJeok = new ArrayList<SeongJeok>();
		int menu;
		
		while(true){
			System.out.println("\n*** �޴� ***");
			System.out.println("1. ���� �Է�");
			System.out.println("2. ���� ���");
			System.out.println("3. ���� �˻�");
			System.out.println("4. ���� ����");
			System.out.println("5. ���� ����");
			System.out.println("6. ��      ��\n");
			
			System.out.println("�޴� ����(1~6) => ");
			menu = sc.nextInt();
			
			switch(menu){
			case 1:
				input_seongJeok(seongJeok);
				break;
			case 2:
				output_seongJeok(seongJeok);
				break;
			case 3:
				search_seongJeok(seongJeok);
				break;
			case 4:
				update_seongJeok(seongJeok);
				break;
			case 5:
				delete_seongJeok(seongJeok);
				break;
			case 6:
				System.out.println("\n���α׷� ����...");
				break;
			default:
				System.out.println("\n�޴��� �ٽ� �����ϼ���!!");
				break;
			}
			if(menu==6)
				break;
		}
	}

	public static void input_seongJeok(ArrayList<SeongJeok> seongJeok) {
		SeongJeok obj = new SeongJeok();

		obj.input();
		for (int i = 0; i < seongJeok.size(); i++) {
			if(obj.hakbun.equals(seongJeok.get(i).hakbun)){
				System.out.println("\n �̹� �Էµ� �й��Դϴ�.");
				return;
			}
		}
		obj.process();
		seongJeok.add(obj);
		System.out.println("\n���� �Է� �Ϸ�\n");
	}

	public static void output_seongJeok(ArrayList<SeongJeok> seongJeok) {
		SeongJeok obj = null;
		
		if(seongJeok.size()==0){
			System.out.println("�Էµ� �����Ͱ� �����ϴ�. �����͸� �Է��ϼ���.");
			return;
		}
		System.out.println("\n           <<����>>");
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		System.out.println("�й�      �̸�        ����     ����     ����     ����      ���        ���");
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		for (int i = 0; i < seongJeok.size(); i++) {
			obj=seongJeok.get(i);
			obj.output();
		}
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�\n");
		System.out.println("\n���� ��� �Ϸ�!!\n");
	}

	public static void search_seongJeok(ArrayList<SeongJeok> seongJeok) {
		String hakbunCheck;
		SeongJeok obj = null;

		Scanner sc = new Scanner(System.in);
		System.out.print("����� �й��� �Է��ϼ��� : ");
		hakbunCheck = sc.next();
		
		for (int i = 0; i < seongJeok.size(); i++) {
			obj=seongJeok.get(i);
		}
		for (int i = 0; i < seongJeok.size(); i++) {
			if(seongJeok.get(i).hakbun.equals(hakbunCheck)){
				System.out.printf("\n           <<�˻��� %3s �й��� ����>>\n",seongJeok.get(i).hakbun);
				System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
				System.out.println("�й�      �̸�        ����     ����     ����     ����      ���        ���");
				System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
				System.out.printf("%3s  %3s   %3d  %3d  %3d  %3d  %3s   %2s \n",
									seongJeok.get(i).hakbun,
									seongJeok.get(i).irum,
									seongJeok.get(i).kor,
									seongJeok.get(i).eng,
									seongJeok.get(i).math,
									seongJeok.get(i).tot,
									seongJeok.get(i).avg,
									seongJeok.get(i).grade
									);
				System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
			}
		}
		System.out.println("�������� �ʴ� �й��Դϴ�.");
	}

	public static void update_seongJeok(ArrayList<SeongJeok> seongJeok) {
		String hakbunCheck;
		SeongJeok obj = null;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < seongJeok.size(); i++) {
			obj=seongJeok.get(i);
		}
		
		System.out.print("������ �й��� �Է��ϼ��� : ");
		hakbunCheck = sc.next();
		
		
		for (int i = 0; i < seongJeok.size(); i++) {
			if(seongJeok.get(i).hakbun.equals(hakbunCheck)){
				System.out.print("���� �Է� : ");
				seongJeok.get(i).kor = sc.nextInt();
				System.out.print("���� �Է� : ");
				seongJeok.get(i).eng = sc.nextInt();
				System.out.print("���� �Է� : ");
				seongJeok.get(i).math = sc.nextInt();
				
				seongJeok.get(i).process();
				System.out.println("\n���� ���� �Ϸ�\n");
			}
		}
	}

	public static void delete_seongJeok(ArrayList<SeongJeok> seongJeok) {
		String hakbunSet;
		SeongJeok obj = null;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < seongJeok.size(); i++) {
			obj=seongJeok.get(i);
		}
		
		System.out.print("������ �й��� �Է��ϼ��� : ");
		hakbunSet = sc.next();
		for (int i = 0; i < seongJeok.size(); i++) {
			if(seongJeok.get(i).hakbun.equals(hakbunSet)){
				seongJeok.remove(i);
				System.out.printf("\n ���� ���� �Ϸ�\n");
			}
		}
		System.out.println("�������� �ʴ� �й��Դϴ�.");
	}
}


