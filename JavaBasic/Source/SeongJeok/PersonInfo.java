package SeongJeok;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonInfo extends Person implements Personable{
	String phone, addr; 
	static int infoCount=0;
	Scanner sc = new Scanner(System.in);
	Person p = new Person();
	static ArrayList<String> personList = new ArrayList<String>();
	
	PersonInfo(){
		
	}
	
	@Override
	public boolean input() {
		
		System.out.print("�й� �Է� : ");
		p.hakbun = sc.next();
		if(p.hakbun.toLowerCase().equals("exit"))
			return true;
		System.out.print("�̸� �Է� : ");
		p.irum = sc.next();
		System.out.print("�޴��� ��ȣ �Է� : ");
		phone = sc.next();
		System.out.print("�ּ� �Է� : ");
		addr = sc.next();
		infoCount++;
		
		
		personList.add(p.hakbun);
		personList.add(p.irum);
		personList.add(phone);
		personList.add(addr);
		
		return false;
	}

	@Override
	public void output() {
		System.out.printf("%4s      %4s    %4s     %3s  \n", p.hakbun, p.irum, phone, addr);
	}

}
