package chap06.Abstract;

public class InheritanceExample6 {
	public static void main(String[] args) {
		EmailSender obj1 = new EmailSender("������ �����մϴ�", "������","admin@naver.com","10% ���������� ����Ǿ����ϴ�.");
		SMSSender obj2 = new SMSSender("������ �����մϴ�" , "������","02-000-0000","10%  ���������� ����Ǿ����ϴ�.");
		
		obj1.sendMessage("asdfsdf@naver.com");
		obj1.sendMessage("ejfieof@gmail.com");
		obj2.sendMessage("010-0000-0000");
	}
}
