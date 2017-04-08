package CHap16.NestedClass;

public class NestedClassExample9 {
	public static void main(String[] args) {
		MessageSender obj = new MessageSender(){
			void send(String message){
				System.out.println("¹ß½Å : ¸¶ÀÌ´Ù½º");
				System.out.println("¼ö½Å : ºô °ÔÀÌÃ÷");
				System.out.println("¸Ş½ÃÁö : "+ message);
				System.out.println();
			}
		};
		obj.send("±Â ¸ğ´×");
	}
}
