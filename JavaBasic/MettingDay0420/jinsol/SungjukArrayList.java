package jinsol;

import java.util.ArrayList;
import java.util.Scanner;

public class SungjukArrayList {
	
	public static void main(String[] args) {
		ArrayList<Sungjuk> sungjuk = new ArrayList<Sungjuk>();
		Scanner scan = new Scanner(System.in);
		
		while(true)
		{
			int menu;
			
			System.out.println("\n*** �޴� ***");
			System.out.println("1. ���� �Է�");
			System.out.println("2. ���� ���");
			System.out.println("3. ���� ��ȸ");
			System.out.println("4. ���� ����");
			System.out.println("5. ���� ����");
			System.out.println("6. ��     ��\n");
			
			System.out.print("�޴� ����(1~6) => ");
			menu = scan.nextInt();
			
			switch (menu)
			{
				case 1:
					input_sungjuk(sungjuk);
					break;
				case 2:
					output_sungjuk(sungjuk);
					break;
				case 3:
					search_sungjuk(sungjuk);
					break;
				case 4:
					update_sungjuk(sungjuk);
					break;
				case 5:
					delete_sungjuk(sungjuk);
					break;
				case 6:
					System.out.println("\n���α׷� ����...");
					break;
				default:
					System.out.println("\n�޴��� �ٽ� �����ϼ���!!!");
					break;
			}
			
			if (menu == 6)
			{
				break;
			}
		}
	}
	static void input_sungjuk(ArrayList<Sungjuk> sungjuk)
	{
		Sungjuk obj = new Sungjuk();
		
		System.out.println();
		obj.input();
		for (int i = 0; i < sungjuk.size(); i++) // �ߺ� ���� üũ
		{
			if (obj.hakbun.equals(sungjuk.get(i).hakbun))
			{
				System.out.println("\n�̹� �Էµ� �й��Դϴ�!!!");
				return; // �ߺ� ������ Ȯ�� �Ǿ��� ������ ȣ���� �������� ����
			}
		}
		
		obj.process(); // �ߺ������� �����Ƿ� ���
		sungjuk.add(obj); // ��������Ʈ�� ���� ��ü �߰�
		
		System.out.println("\n���� �Է� ����!!!");
	}
	
	static void output_sungjuk(ArrayList<Sungjuk> sungjuk)
	{
		if (sungjuk.size() == 0)
		{
			System.out.println("\n����� �����Ͱ� �����ϴ�!!!");
			return;
		}
		
		System.out.println();
		System.out.println("\n                *** ����ǥ ***");
		System.out.println("==============================================");
		System.out.println(" �й�    �̸�     ����    ����    ����    ����    ���    ���");
		System.out.println("==============================================");
		for (Sungjuk obj : sungjuk)
			obj.output();
		System.out.println("==============================================");
	}
	
	static void search_sungjuk(ArrayList<Sungjuk> sungjuk)
	{
		Scanner scan = new Scanner(System.in);
		Sungjuk obj;
		
		System.out.print("\n��ȸ�� �й� �Է�  => ");
		String hakbun = scan.next();
		
		for (int i = 0; i < sungjuk.size(); i++)
		{
			obj = sungjuk.get(i);
			if (hakbun.equals(obj.hakbun))
			{
				System.out.println();
				System.out.println("�й� : " + obj.hakbun);
				System.out.println("�̸� : " + obj.irum);
				System.out.println("���� : " + obj.kor);
				System.out.println("���� : " + obj.eng);
				System.out.println("���� : " + obj.math);
				System.out.println("���� : " + obj.tot);
				System.out.println("��� : " + obj.avg);
				System.out.println("��� : " + obj.grade);
				return;
			}
		}
		System.out.println("\n�������� �ʴ� �й��Դϴ�!!!");
	}
	
	static void update_sungjuk(ArrayList<Sungjuk> sungjuk)
	{
		Scanner scan = new Scanner(System.in);
		Sungjuk obj;
		
		System.out.print("\n������ �й� �Է� => ");
		String hakbun = scan.next();
		
		for (int i = 0; i < sungjuk.size(); i++)
		{
			obj = sungjuk.get(i);
			if (hakbun.equals(obj.hakbun))
			{
				System.out.print("\n���� �Է� => ");
				obj.kor = scan.nextInt();
				System.out.print("���� �Է� => ");
				obj.eng = scan.nextInt();
				System.out.print("���� �Է� => ");
				obj.math = scan.nextInt();
				
				obj.process();
				
				System.out.println("\n" + hakbun + " �й� ���� �Ϸ�!!!");
				return;
			}
		}
		System.out.println("\n�������� �ʴ� �й��Դϴ�!!!");
	}
	
	static void delete_sungjuk(ArrayList<Sungjuk> sungjuk)
	{
		Scanner scan = new Scanner(System.in);
		Sungjuk obj;
		
		System.out.print("\n������ �й� �Է� => ");
		String hakbun = scan.next();
		
		for (int i = 0; i < sungjuk.size(); i++)
		{
			obj = sungjuk.get(i);
			if (hakbun.equals(obj.hakbun))
			{
				sungjuk.remove(i);
				System.out.println("\n" + hakbun + " �й� ���� �Ϸ�!!!");
				return;
			}
		}
		System.out.println("\n�������� �ʴ� �й��Դϴ�!!!");
	}
}