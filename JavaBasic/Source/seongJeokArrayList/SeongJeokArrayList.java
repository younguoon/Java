package seongJeokArrayList;
import java.util.ArrayList;
import java.util.Scanner;

public class SeongJeokArrayList {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<SeongJeok> seongJeok = new ArrayList<SeongJeok>();
		int menu;
		
		while(true){
			System.out.println("\n*** 메뉴 ***");
			System.out.println("1. 성적 입력");
			System.out.println("2. 성적 출력");
			System.out.println("3. 성적 검색");
			System.out.println("4. 성적 수정");
			System.out.println("5. 성적 삭제");
			System.out.println("6. 종      료\n");
			
			System.out.println("메뉴 선택(1~6) => ");
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
				System.out.println("\n프로그램 종료...");
				break;
			default:
				System.out.println("\n메뉴를 다시 선택하세요!!");
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
				System.out.println("\n 이미 입력된 학번입니다.");
				return;
			}
		}
		obj.process();
		seongJeok.add(obj);
		System.out.println("\n성적 입력 완료\n");
	}

	public static void output_seongJeok(ArrayList<SeongJeok> seongJeok) {
		SeongJeok obj = null;
		
		if(seongJeok.size()==0){
			System.out.println("입력된 데이터가 없습니다. 데이터를 입력하세요.");
			return;
		}
		System.out.println("\n           <<성적>>");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("학번      이름        국어     영어     수학     총점      평균        등급");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		for (int i = 0; i < seongJeok.size(); i++) {
			obj=seongJeok.get(i);
			obj.output();
		}
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
		System.out.println("\n성적 출력 완료!!\n");
	}

	public static void search_seongJeok(ArrayList<SeongJeok> seongJeok) {
		String hakbunCheck;
		SeongJeok obj = null;

		Scanner sc = new Scanner(System.in);
		System.out.print("출력할 학번을 입력하세요 : ");
		hakbunCheck = sc.next();
		
		for (int i = 0; i < seongJeok.size(); i++) {
			obj=seongJeok.get(i);
		}
		for (int i = 0; i < seongJeok.size(); i++) {
			if(seongJeok.get(i).hakbun.equals(hakbunCheck)){
				System.out.printf("\n           <<검색된 %3s 학번의 성적>>\n",seongJeok.get(i).hakbun);
				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
				System.out.println("학번      이름        국어     영어     수학     총점      평균        등급");
				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
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
				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			}
		}
		System.out.println("존재하지 않는 학번입니다.");
	}

	public static void update_seongJeok(ArrayList<SeongJeok> seongJeok) {
		String hakbunCheck;
		SeongJeok obj = null;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < seongJeok.size(); i++) {
			obj=seongJeok.get(i);
		}
		
		System.out.print("수정할 학번을 입력하세요 : ");
		hakbunCheck = sc.next();
		
		
		for (int i = 0; i < seongJeok.size(); i++) {
			if(seongJeok.get(i).hakbun.equals(hakbunCheck)){
				System.out.print("국어 입력 : ");
				seongJeok.get(i).kor = sc.nextInt();
				System.out.print("영어 입력 : ");
				seongJeok.get(i).eng = sc.nextInt();
				System.out.print("수학 입력 : ");
				seongJeok.get(i).math = sc.nextInt();
				
				seongJeok.get(i).process();
				System.out.println("\n성적 수정 완료\n");
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
		
		System.out.print("삭제할 학번을 입력하세요 : ");
		hakbunSet = sc.next();
		for (int i = 0; i < seongJeok.size(); i++) {
			if(seongJeok.get(i).hakbun.equals(hakbunSet)){
				seongJeok.remove(i);
				System.out.printf("\n 성적 삭제 완료\n");
			}
		}
		System.out.println("존재하지 않는 학번입니다.");
	}
}


