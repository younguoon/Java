package chap06.Interface;

public class InterfaceExample1 {
	public static void main(String[] args) {
		SeparateVolume obj1 = new SeparateVolume("863774��", "����", "��������");
		AppCDInfo obj2 = new AppCDInfo("2005-7001", "Redhat Fedora");
//		obj1.checkOut("�迵��", "20060315");
//		obj2.checkOut("�����", "20060317");
		printCheckOut(obj1, "�迵��", "20060315");
		printCheckOut(obj2, "�迵��", "20060315");
		
		printCheckIn(obj1);
		printCheckIn(obj2);
//		obj1.checkIn();
//		obj2.checkIn();

	}
	static void printCheckOut(Lendable obj, String irum, String checkOutDate){
		obj.checkOut(irum, checkOutDate);
	}
	
	static void printCheckIn(Lendable obj){
		obj.checkIn();
	}
}
