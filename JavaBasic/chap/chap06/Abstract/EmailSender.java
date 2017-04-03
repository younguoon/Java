package chap06.Abstract;

public class EmailSender extends MessageSender{
	String senderAddr;
	String emailBody;

	public EmailSender(String title, String senderName, String senderAddr, String emailBody) {
		super(title, senderName);
		this.senderAddr = senderAddr;
		this.emailBody = emailBody;
	}
	void sendMessage(String reicipient){
		System.out.println("------------------------");
		System.out.println("���� : "+title);
		System.out.println("������ ��� : "+senderName+ " "+reicipient);
		System.out.println("���� : "+emailBody);
	}


}
