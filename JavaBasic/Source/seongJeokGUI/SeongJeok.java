package seongJeokGUI;

import java.util.Scanner;

public class SeongJeok {
	String hakbun, irum, grade;
	int kor, eng, math, tot;
	double avg;
	
	SeongJeok(){
	}


	public SeongJeok(String hakbun, String irum, int kor, int eng, int math, int tot, double avg, String grade) {
//		super();
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
		System.out.print("이름 입력 : ");
		irum = sc.next();
		System.out.print("국어 입력 : ");
		kor = sc.nextInt();
		System.out.print("영어 입력 : ");
		eng = sc.nextInt();
		System.out.print("수학 입력 : ");
		math = sc.nextInt();
		return false;
	}
	
	void output() {
		System.out.printf("%3s  %3s   %3d  %3d  %3d  %3d  %3f   %2s \n", 
				hakbun, irum,  kor, eng, math, tot, avg, grade);
	}
	
	void process(){
		tot = kor+eng+math;
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
	}
}

