package chap06.Abstract;

public class InheritanceExample8 {
public static void main(String[] args) {
	EmailSender obj1 = new EmailSender("생일을 축하합니다","고객센터","admin@naver.com","10%할인쿠폰 발급완료");
	SMSSender obj2 = new SMSSender("생일을 축하합니다","고객센터","02-000-0000","10%할인쿠폰 발급완료");
	
	send(obj1, "hatman@naver.com");
	send(obj1, "fjskdf@yahoo.com");
	send(obj2, "010-000-0000");
	
}
static void send(MessageSender obj, String recipient){
	obj.sendMessage(recipient);
}
}
