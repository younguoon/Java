package chap05.Method;

public class MethodExample4 {
	public static void main(String[] args) {
		int arr[] = new int[0];
		Numbers obj = new Numbers(arr);
		try{
		int average = obj.getAverage();
		System.out.println("��� : "+average);
		}
		catch (Exception e) {
			System.out.println("����� ����ϴ� ���� ������ �߻��߽��ϴ�."+e.getMessage());
		}
	}
}
