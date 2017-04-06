package chap10.FileIO;

public class ObjectExample2 {
	public static void main(String[] args) {
		GoodsStock obj = new GoodsStock("jilcd", 100);
		String str = obj.toString();
		System.out.println(str);
	}
}
