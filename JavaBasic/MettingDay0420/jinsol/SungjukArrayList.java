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
			
			System.out.println("\n*** 메뉴 ***");
			System.out.println("1. 성적 입력");
			System.out.println("2. 성적 출력");
			System.out.println("3. 성적 조회");
			System.out.println("4. 성적 수정");
			System.out.println("5. 성적 삭제");
			System.out.println("6. 종     료\n");
			
			System.out.print("메뉴 선택(1~6) => ");
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
					System.out.println("\n프로그램 종료...");
					break;
				default:
					System.out.println("\n메뉴를 다시 선택하세요!!!");
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
		for (int i = 0; i < sungjuk.size(); i++) // 중복 오류 체크
		{
			if (obj.hakbun.equals(sungjuk.get(i).hakbun))
			{
				System.out.println("\n이미 입력된 학번입니다!!!");
				return; // 중복 오류가 확인 되었기 때문에 호출한 메인으로 복귀
			}
		}
		
		obj.process(); // 중복오류가 없으므로 계산
		sungjuk.add(obj); // 성적리스트에 성적 객체 추가
		
		System.out.println("\n성적 입력 성공!!!");
	}
	
	static void output_sungjuk(ArrayList<Sungjuk> sungjuk)
	{
		if (sungjuk.size() == 0)
		{
			System.out.println("\n출력할 데이터가 없습니다!!!");
			return;
		}
		
		System.out.println();
		System.out.println("\n                *** 성적표 ***");
		System.out.println("==============================================");
		System.out.println(" 학번    이름     국어    영어    수학    총점    평균    등급");
		System.out.println("==============================================");
		for (Sungjuk obj : sungjuk)
			obj.output();
		System.out.println("==============================================");
	}
	
	static void search_sungjuk(ArrayList<Sungjuk> sungjuk)
	{
		Scanner scan = new Scanner(System.in);
		Sungjuk obj;
		
		System.out.print("\n조회할 학번 입력  => ");
		String hakbun = scan.next();
		
		for (int i = 0; i < sungjuk.size(); i++)
		{
			obj = sungjuk.get(i);
			if (hakbun.equals(obj.hakbun))
			{
				System.out.println();
				System.out.println("학번 : " + obj.hakbun);
				System.out.println("이름 : " + obj.irum);
				System.out.println("국어 : " + obj.kor);
				System.out.println("영어 : " + obj.eng);
				System.out.println("수학 : " + obj.math);
				System.out.println("총점 : " + obj.tot);
				System.out.println("평균 : " + obj.avg);
				System.out.println("등급 : " + obj.grade);
				return;
			}
		}
		System.out.println("\n존재하지 않는 학번입니다!!!");
	}
	
	static void update_sungjuk(ArrayList<Sungjuk> sungjuk)
	{
		Scanner scan = new Scanner(System.in);
		Sungjuk obj;
		
		System.out.print("\n수정할 학번 입력 => ");
		String hakbun = scan.next();
		
		for (int i = 0; i < sungjuk.size(); i++)
		{
			obj = sungjuk.get(i);
			if (hakbun.equals(obj.hakbun))
			{
				System.out.print("\n국어 입력 => ");
				obj.kor = scan.nextInt();
				System.out.print("영어 입력 => ");
				obj.eng = scan.nextInt();
				System.out.print("수학 입력 => ");
				obj.math = scan.nextInt();
				
				obj.process();
				
				System.out.println("\n" + hakbun + " 학번 수정 완료!!!");
				return;
			}
		}
		System.out.println("\n존재하지 않는 학번입니다!!!");
	}
	
	static void delete_sungjuk(ArrayList<Sungjuk> sungjuk)
	{
		Scanner scan = new Scanner(System.in);
		Sungjuk obj;
		
		System.out.print("\n삭제할 학번 입력 => ");
		String hakbun = scan.next();
		
		for (int i = 0; i < sungjuk.size(); i++)
		{
			obj = sungjuk.get(i);
			if (hakbun.equals(obj.hakbun))
			{
				sungjuk.remove(i);
				System.out.println("\n" + hakbun + " 학번 삭제 완료!!!");
				return;
			}
		}
		System.out.println("\n존재하지 않는 학번입니다!!!");
	}
}