package chap06.Interface;

public class InterfaceExample2 {
	public static void main(String[] args) {
		Lendable arr[] = new Lendable[3];
		arr[0] = new SeparateVolume("833", "Ǫ���� ����","����");
		arr[1] = new SeparateVolume("609", "����̼���","���긮ġ");
		arr[2] = new AppCDInfo("02-17","XML�� ���� �ڹ� ���α׷���");
		checkOutAll(arr, "������", "20060315");
	}
	static void checkOutAll(Lendable arr[], String borrower, String date){
		for (int cnt = 0; cnt < arr.length; cnt++) {
			arr[cnt].checkOut(borrower, date);
		}
		
	}
}
