package CHap16.NestedClass;

public class NestedClassExample8 {
	public static void main(String[] args) {
		class SatelliteSender extends MessageSender{
			void send(String message){
				System.out.println("�߽� : ���̴ٽ�");
				System.out.println("���� : �� ������");
				System.out.println("�޽��� : "+ message);
				System.out.println();
			}
		}
		SatelliteSender obj = new SatelliteSender();
		obj.send("�� ���");
	}
}
