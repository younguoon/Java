package chap06.Abstract;

public class InheritanceExample6 {
	public static void main(String[] args) {
		EmailSender obj1 = new EmailSender("생일을 축하합니다", "고객센터","admin@naver.com","10% 할인쿠폰이 발행되었습니다.");
		SMSSender obj2 = new SMSSender("생일을 축하합니다" , "고객센터","02-000-0000","10%  할인쿠폰이 발행되었습니다.");
		
		obj1.sendMessage("asdfsdf@naver.com");
		obj1.sendMessage("ejfieof@gmail.com");
		obj2.sendMessage("010-0000-0000");
	}
}
