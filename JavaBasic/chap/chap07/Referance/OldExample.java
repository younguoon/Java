package chap07.Referance;

public class OldExample {
	public static void main(String args[]) {
        ClothingInfo obj = new ClothingInfo("32919", "���� Ƽ����", "��100%", Season.SUMMER);
        System.out.println("��ǰ�ڵ�: " + obj.code);
        System.out.println("��ǰ��: " + obj.name);
        System.out.println("����: " + obj.material);
        System.out.println("��������: " + obj.season);
    }
}
