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
			System.out.println("\n*** 메뉴 ***");
			System.out.println("1. 성적 입력");
			System.out.println("2. 성적 출력");
			System.out.println("3. 성적 검색");
			System.out.println("4. 성적 수정");
			System.out.println("5. 성적 삭제");
			System.out.println("6. 종      료\n");

			System.out.println("메뉴 선택(1~6) => ");
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
				System.out.println("\n프로그램 종료...");
				break;
			default:
				System.out.println("\n메뉴를 다시 선택하세요!!");
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
				System.out.println("\n 이미 입력된 학번입니다.");
				return;
			}
		}
		obj.process();
		seongJeokHashMap.put(obj.hakbun, obj);
		System.out.println("\n성적 입력 완료\n");
	}

	public static void output_seongJeok(HashMap<String, SeongJeok> seongJeokHashMap) {
		SeongJeok obj;
		Set<String> keyset = seongJeokHashMap.keySet(); //hashmap에 존재하는 키 집합을 구함
//		Set entryset = seongJeokHashMap.entrySet(); //hashmap에 존재하는 키와 값의 집합을 구함

		if(keyset.size() ==0){
			
			System.out.println("출력할 데이터가 없습니다.");
			return;
		}
		
//		Iterator it_entry = entryset.iterator(); //순차적인 접근을 위해 Iterator 객체로 변환
		
		System.out.println("\n <<성적>>");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("학번    이름        국어     영어    수학     총점     평균      등급");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		for(String hakbun : keyset){
			obj = seongJeokHashMap.get(hakbun);
			obj.output();
		}
		
		
////키와 값을 읽기 위해 Map.Entry로 캐스트 연산
//		while(it_entry.hasNext()){
//			Map.Entry e = (Map.Entry) it_entry.next();
////e.getValue(); 데이터 값을 읽어옴, e.getKey() : 키 값을 읽어옴
//			obj = (SeongJeok)e.getValue();
////e.getValue()의 리턴 타입이 Object이므르로 SeongJeok으로 캐스트됨
//			obj.output();
//		}
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
		System.out.println("\n성적 출력 완료!!\n");
	}

	public static void search_seongJeok(HashMap<String, SeongJeok> seongJeokHashMap) {
		String hakbunCheck;
		SeongJeok obj = null;
		Scanner sc = new Scanner(System.in);

		System.out.print("출력할 학번을 입력하세요 : ");
		hakbunCheck = sc.next();

		obj = seongJeokHashMap.get(hakbunCheck);

		if (obj != null) {
			System.out.printf("\n           <<검색된 %3s 학번의 성적>>\n", seongJeokHashMap.get(obj.hakbun).hakbun);
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("학번     이름        국어     영어     수학     총점      평균     등급");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			obj.output();
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		} else
			System.out.println("존재하지 않는 학번입니다.");
	}

	public static void update_seongJeok(HashMap<String, SeongJeok> seongJeokHashMap) {
		String hakbunCheck;
		SeongJeok obj = null;
		Scanner sc = new Scanner(System.in);

		System.out.print("수정할 학번을 입력하세요 : ");
		hakbunCheck = sc.next();

		obj = seongJeokHashMap.get(hakbunCheck);

		if (obj != null) {
			System.out.print("국어 입력 : ");
			obj.kor = sc.nextInt();
			System.out.print("영어 입력 : ");
			obj.eng = sc.nextInt();
			System.out.print("수학 입력 : ");
			obj.math = sc.nextInt();

			obj.process();
			System.out.println("\n성적 수정 완료\n");
		} else
			System.out.println("존재하지 않는 학번입니다.");
	}

	public static void delete_seongJeok(HashMap<String, SeongJeok> seongJeokHashMap) {
		String hakbunSet;
		SeongJeok obj = null;
		Scanner sc = new Scanner(System.in);

		System.out.print("삭제할 학번을 입력하세요 : ");
		hakbunSet = sc.next();

		obj = seongJeokHashMap.get(hakbunSet);

		if (obj != null) {
			seongJeokHashMap.remove(obj.hakbun);
			System.out.printf("\n 성적 삭제 완료\n");
		} else
			System.out.println("존재하지 않는 학번입니다.");
	}
}
