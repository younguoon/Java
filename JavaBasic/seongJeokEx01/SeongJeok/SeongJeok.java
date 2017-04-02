package SeongJeok;
import java.util.Scanner;

public class SeongJeok {
	String hakbun, irum, grade;
	int kor, eng, math, tot;
	double avg;
	static int stdCount=0, totalSeongJeok=0, totalAvg=0;
	//�����޼ҵ�(��ü���), �����ʵ� �ΰ�(�հ贩��, �л��� ī��Ʈ)
	
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
		System.out.print("�й� �Է� : ");
		hakbun = sc.next();
		if(hakbun.toLowerCase().equals("exit"))
			return true;
		System.out.print("�̸� �Է� : ");
		irum = sc.next();
		System.out.print("���� �Է� : ");
		kor = sc.nextInt();
		System.out.print("���� �Է� : ");
		eng = sc.nextInt();
		System.out.print("���� �Է� : ");
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
	
	void output(){
		System.out.printf("%4s  %3s  %3d  %3d  %3d  %3d  %5.2f   %2s \n", 
				hakbun, irum, kor, eng, math, tot, avg, grade);
	}
	
	static int getTotalAvg() {
		return totalSeongJeok/3/stdCount;
	}
}
