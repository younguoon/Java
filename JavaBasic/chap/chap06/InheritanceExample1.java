package chap06;

public class InheritanceExample1 {
	public static void main(String args[]) {
		//����Ʈ�����ڰ� �ڵ�������
		CheckingAccount obj = new CheckingAccount("111-22-33333333","ȫ�浿",0,"5555-6666-7777-8888");
		
//		obj.accountNo = "111-22-33333333";
//		obj.ownerName = "ȫ�浿";
//		obj.cardNo = "5555-6666-7777-8888";
		obj.deposit(100000);
		try {
			int paidAmount = obj.pay("5555-6666-7777-8888", 47000);
			System.out.println("���Ҿ�:" + paidAmount);
			System.out.println("�ܾ�:" + obj.balance);
		} catch (Exception e) {
			String msg = e.getMessage();
			System.out.println(msg);
		}
	}
}
