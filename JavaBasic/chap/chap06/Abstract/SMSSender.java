package chap06.Abstract;

public class SMSSender extends MessageSender{
	String returnPhoneNo;
	String message;
	
	public SMSSender(String title, String senderName, String returnPhoneNo, String message) {
		super(title, senderName);
		this.returnPhoneNo = returnPhoneNo;
		this.message = message;
	}
	void sendMessage(String reicipient){
		System.out.println("------------------------");
		System.out.println("���� : "+title);
		System.out.println("������ ��� : "+senderName+ " "+reicipient);
		System.out.println("��ȭ��ȣ : " + reicipient);
		System.out.println("ȸ�� ��ȭ��ȣ : "+returnPhoneNo);
		System.out.println("�޽��� ���� : "+message);
	}
}
