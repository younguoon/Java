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
		System.out.print("���� �Է� : ");
		kor = sc.nextInt();
		if(kor==1)
			return true;
		System.out.print("���� �Է� : ");
		eng = sc.nextInt();
		System.out.print("���� �Է� : ");
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
			grade = "��";
			break;
		case 8 :
			grade = "��";
			break;
		case 7 :
			grade = "��";
			break;
		case 6 :
			grade = "��";
			break;
		default :
			grade = "��";
			break;
		}
		totalSeongJeok+=tot;
		totalAvg+=avg;
	}
	
	static int getTotalAvg() {
		return totalSeongJeok/3/stdCount;
	}
}
