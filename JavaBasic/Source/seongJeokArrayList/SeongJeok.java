package seongJeokArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class SeongJeok {
	String hakbun, irum, grade;
	int kor, eng, math, tot, avg;
	
	SeongJeok(){
	}
	
	boolean input(){
		Scanner sc = new Scanner(System.in);
		System.out.print("�й� �Է� : ");
		hakbun = sc.next();
		System.out.print("�̸� �Է� : ");
		irum = sc.next();
		System.out.print("���� �Է� : ");
		kor = sc.nextInt();
		System.out.print("���� �Է� : ");
		eng = sc.nextInt();
		System.out.print("���� �Է� : ");
		math = sc.nextInt();
		return false;
		
	}
	
	void output() {
		System.out.printf("%3s  %3s   %3d  %3d  %3d  %3d  %3s   %2s \n", 
				hakbun, irum,  kor, eng, math, tot, avg, grade);
	}
	
	void process(){
		tot = kor+eng+math;
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
	}
}

