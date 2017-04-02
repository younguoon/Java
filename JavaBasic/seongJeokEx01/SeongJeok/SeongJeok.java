package SeongJeok;
import java.util.Scanner;

public class SeongJeok {
	String hakbun, irum, grade;
	int kor, eng, math, tot;
	double avg;
	static int stdCount=0, totalSeongJeok=0, totalAvg=0;
	//정적메소드(전체평균), 정적필드 두개(합계누적, 학생수 카운트)
	
	public SeongJeok(){
		
	}
	
	public SeongJeok(String hakbun, String irum, String grade, int kor, int eng, int math, int tot, double avg) {
		super();
		this.hakbun = hakbun;
		this.irum = irum;
		this.grade = grade;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.tot = tot;
		this.avg = avg;
	}
	
	
	boolean input(){
		Scanner sc = new Scanner(System.in);
		System.out.print("학번 입력 : ");
		hakbun = sc.next();
		if(hakbun.toLowerCase().equals("exit"))
			return true;
		System.out.print("이름 입력 : ");
		irum = sc.next();
		System.out.print("국어 입력 : ");
		kor = sc.nextInt();
		System.out.print("영어 입력 : ");
		eng = sc.nextInt();
		System.out.print("수학 입력 : ");
		math = sc.nextInt();
		stdCount++;
		return false;
	}
	
	void process(){
		this.tot = kor+eng+math;
		avg = tot/3;
		
		switch((int)avg/10){
		case 10:
		case 9 :
			grade = "수";
			break;
		case 8 :
			grade = "우";
			break;
		case 7 :
			grade = "미";
			break;
		case 6 :
			grade = "양";
			break;
		default :
			grade = "가";
			break;
		}
		totalSeongJeok+=tot;
		totalAvg+=avg;
	}
	
	void output(){
		System.out.printf("%4s  %3s  %3d  %3d  %3d  %3d  %5.2f   %2s \n", 
				hakbun, irum, kor, eng, math, tot, avg, grade);
	}
	
	static int getTotalAvg() {
		return totalSeongJeok/3/stdCount;
	}
}
