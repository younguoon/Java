package SeongJeok;

public class SeongJeokEx01 {
	final static int MAX = 1000;
	public static void main(String[] args) {
		SeongJeok obj[] = new SeongJeok[MAX];
		
		inputSeongJeok(obj);

		System.out.println("\n               ***성적표***");
		System.out.println("================================================");
		System.out.println("\n학번      이름      국어    영어    수학     총점    평균     등급");
		System.out.println("================================================");
		outputSeongJeok(obj);
		System.out.println("================================================");
		System.out.printf("		학생 수 : %3d 	전체 평균 : %3d ",SeongJeok.stdCount, SeongJeok.getTotalAvg());
		//정적메소드(전체평균), 정적필드 두개(합계누적, 학생수 카운트) 누적합계, 전체평균, 전체 학생 수
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
