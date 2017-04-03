package SeongJeok;
import java.util.Scanner;

public class SeongJeok extends Person implements Personable{
	String grade;
	int kor, eng, math, tot;
	double avg;
	static int stdCount=0, totalSeongJeok=0, totalAvg=0;
	Person p = new Person();
	
	SeongJeok(){
	}
	
	@Override
	public boolean input(){
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 입력 : ");
		kor = sc.nextInt();
		if(kor==1)
			return true;
		System.out.print("영어 입력 : ");
		eng = sc.nextInt();
		System.out.print("수학 입력 : ");
		math = sc.nextInt();
		stdCount++;
		return false;
	}
	@Override
	public void output() {
		System.out.printf("%3d  %3d  %3d  %3d  %5.2f   %2s \n", 
				kor, eng, math, tot, avg, grade);
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
	
	static int getTotalAvg() {
		return totalSeongJeok/3/stdCount;
	}
}
