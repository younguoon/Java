package chap06.Abstract;

public class InheritanceExample8 {
public static void main(String[] args) {
	EmailSender obj1 = new EmailSender("������ �����մϴ�","������","admin@naver.com","10%�������� �߱޿Ϸ�");
	SMSSender obj2 = new SMSSender("������ �����մϴ�","������","02-000-0000","10%�������� �߱޿Ϸ�");
	
	send(obj1, "hatman@naver.com");
	send(obj1, "fjskdf@yahoo.com");
	send(obj2, "010-000-0000");
	
}
static void send(MessageSender obj, String recipient){
	obj.sendMessage(recipient);
}
}
