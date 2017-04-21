package sungJuk.jdbc;

import java.util.Scanner;

public class Sungjuk {
	String hakbun, irum, grade;
	int kor, eng, math, tot;
	double avg;

	Sungjuk() {
	}

	void input() {
		Scanner scan = new Scanner(System.in);

		System.out.print("학번 입력 => ");
		hakbun = scan.next();
		System.out.print("이름 입력 => ");
		irum = scan.next();
		System.out.print("국어 입력 => ");
		kor = scan.nextInt();
		System.out.print("영어 입력 => ");
		eng = scan.nextInt();
		System.out.print("수학 입력 => ");
		math = scan.nextInt();
	}

	void process() {
		tot = kor + eng + math;
		avg = tot / 3;

		switch ((int) avg / 10) {
		case 10:
		case 9:
			grade = "수";
			break;
		case 8:
			grade = "우";
			break;
		case 7:
			grade = "미";
			break;
		case 6:
			grade = "양";
			break;
		default:
			grade = "가";
			break;
		}
	}

	void output() {
		System.out.printf("%4s  %3s   %4d  %4d  %4d  %4d  %4f %3s\n", hakbun, irum, kor, eng, math, tot, avg, grade);
	}
}
