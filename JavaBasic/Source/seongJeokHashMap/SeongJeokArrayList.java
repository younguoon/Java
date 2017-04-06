package seongJeokHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SeongJeokArrayList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<SeongJeok> seongJeok = new ArrayList<SeongJeok>();
		HashMap<String, SeongJeok> seongJeokHashMap = new HashMap<String, SeongJeok>();

		int menu;

		while (true) {
			System.out.println("\n*** �޴� ***");
			System.out.println("1. ���� �Է�");
			System.out.println("2. ���� ���");
			System.out.println("3. ���� �˻�");
			System.out.println("4. ���� ����");
			System.out.println("5. ���� ����");
			System.out.println("6. ��      ��\n");

			System.out.println("�޴� ����(1~6) => ");
			menu = sc.nextInt();

			switch (menu) {
			case 1:
				input_seongJeok(seongJeokHashMap);
				break;
			case 2:
				output_seongJeok(seongJeokHashMap);
				break;
			case 3:
				search_seongJeok(seongJeokHashMap);
				break;
			case 4:
				update_seongJeok(seongJeokHashMap);
				break;
			case 5:
				delete_seongJeok(seongJeokHashMap);
				break;
			case 6:
				System.out.println("\n���α׷� ����...");
				break;
			default:
				System.out.println("\n�޴��� �ٽ� �����ϼ���!!");
				break;
			}
			if (menu == 6)
				break;
		}
	}

	public static void input_seongJeok(HashMap<String, SeongJeok> seongJeokHashMap) {
		SeongJeok obj = new SeongJeok();

		obj.input();
		for (int i = 0; i < seongJeokHashMap.size(); i++) {
			// if(hashmap.containskey(obj.hakbun))
			if (seongJeokHashMap.get(obj.hakbun) != null) {
				System.out.println("\n �̹� �Էµ� �й��Դϴ�.");
				return;
			}
		}
		obj.process();
		seongJeokHashMap.put(obj.hakbun, obj);
		System.out.println("\n���� �Է� �Ϸ�\n");
	}

	public static void output_seongJeok(HashMap<String, SeongJeok> seongJeokHashMap) {
		SeongJeok obj;
		Set<String> keyset = seongJeokHashMap.keySet(); //hashmap�� �����ϴ� Ű ������ ����
//		Set entryset = seongJeokHashMap.entrySet(); //hashmap�� �����ϴ� Ű�� ���� ������ ����

		if(keyset.size() ==0){
			
			System.out.println("����� �����Ͱ� �����ϴ�.");
			return;
		}
		
//		Iterator it_entry = entryset.iterator(); //�������� ������ ���� Iterator ��ü�� ��ȯ
		
		System.out.println("\n <<����>>");
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		System.out.println("�й�    �̸�        ����     ����    ����     ����     ���      ���");
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		for(String hakbun : keyset){
			obj = seongJeokHashMap.get(hakbun);
			obj.output();
		}
		
		
////Ű�� ���� �б� ���� Map.Entry�� ĳ��Ʈ ����
//		while(it_entry.hasNext()){
//			Map.Entry e = (Map.Entry) it_entry.next();
////e.getValue(); ������ ���� �о��, e.getKey() : Ű ���� �о��
//			obj = (SeongJeok)e.getValue();
////e.getValue()�� ���� Ÿ���� Object�̹Ǹ��� SeongJeok���� ĳ��Ʈ��
//			obj.output();
//		}
		
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�\n");
		System.out.println("\n���� ��� �Ϸ�!!\n");
	}

	public static void search_seongJeok(HashMap<String, SeongJeok> seongJeokHashMap) {
		String hakbunCheck;
		SeongJeok obj = null;
		Scanner sc = new Scanner(System.in);

		System.out.print("����� �й��� �Է��ϼ��� : ");
		hakbunCheck = sc.next();

		obj = seongJeokHashMap.get(hakbunCheck);

		if (obj != null) {
			System.out.printf("\n           <<�˻��� %3s �й��� ����>>\n", seongJeokHashMap.get(obj.hakbun).hakbun);
			System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
			System.out.println("�й�     �̸�        ����     ����     ����     ����      ���     ���");
			System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
			obj.output();
			System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		} else
			System.out.println("�������� �ʴ� �й��Դϴ�.");
	}

	public static void update_seongJeok(HashMap<String, SeongJeok> seongJeokHashMap) {
		String hakbunCheck;
		SeongJeok obj = null;
		Scanner sc = new Scanner(System.in);

		System.out.print("������ �й��� �Է��ϼ��� : ");
		hakbunCheck = sc.next();

		obj = seongJeokHashMap.get(hakbunCheck);

		if (obj != null) {
			System.out.print("���� �Է� : ");
			obj.kor = sc.nextInt();
			System.out.print("���� �Է� : ");
			obj.eng = sc.nextInt();
			System.out.print("���� �Է� : ");
			obj.math = sc.nextInt();

			obj.process();
			System.out.println("\n���� ���� �Ϸ�\n");
		} else
			System.out.println("�������� �ʴ� �й��Դϴ�.");
	}

	public static void delete_seongJeok(HashMap<String, SeongJeok> seongJeokHashMap) {
		String hakbunSet;
		SeongJeok obj = null;
		Scanner sc = new Scanner(System.in);

		System.out.print("������ �й��� �Է��ϼ��� : ");
		hakbunSet = sc.next();

		obj = seongJeokHashMap.get(hakbunSet);

		if (obj != null) {
			seongJeokHashMap.remove(obj.hakbun);
			System.out.printf("\n ���� ���� �Ϸ�\n");
		} else
			System.out.println("�������� �ʴ� �й��Դϴ�.");
	}
}
