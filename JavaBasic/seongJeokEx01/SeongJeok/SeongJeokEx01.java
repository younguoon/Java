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

//성적입력, 개인정보입력 통합
	static int input(SeongJeok o1[], PersonInfo o2[]){
		int i, cnt=0;
		for (i = 0; i < MAX; i++) {
			System.out.println("*********성적 입력*********\n");
			o1[i] = new SeongJeok();
			if(o1[i].input())
				break;
			o1[i].process();
			System.out.println();
			System.out.println("*********개인정보 입력*********\n");
			o2[i] = new PersonInfo();
			if(o2[i].input())
				break;
			System.out.println();
		}
		
		return cnt;
	}
	
//성적, 개인정보 출력
		static void output(SeongJeok o1[], PersonInfo o2[]){
			int i;
			
			//성적
			System.out.println("\n           <<성적>>");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("국어    영어    수학     총점    평균              등급");
			for (i = 0; i < SeongJeok.stdCount; i++) {
				o1[i].output();
			}	
			System.out.printf("	     학생수 : %2d   전체평균 : %2d ",SeongJeok.stdCount, SeongJeok.getTotalAvg());
			
			
			//개인정보
			System.out.println("\n\n          <<개인정보>>");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println(" 학번               이름           휴대폰번호   주소");
			for (i = 0; i < PersonInfo.infoCount; i++) {
				o2[i].output();
			}	
		}
	
	
		
		
		
		
		
		
//-------------------------------------------------------------------------------------
		
		
		
//성적입력
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
	
//성적 출력
	static void outputSeongJeok(SeongJeok o[]){
		int i;
		for (i = 0; i < SeongJeok.stdCount; i++) {
			o[i].output();
		}	
	}

//개인정보 입력
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

//개인정보 출력
	static void outputPersonInfo(PersonInfo o[]){
		int i;
		for (i = 0; i < PersonInfo.infoCount; i++) {
			o[i].output();
		}	
	}
}
