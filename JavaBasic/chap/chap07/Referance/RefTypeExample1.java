package chap07.Referance;

public class RefTypeExample1 {
    public static void main(String args[]) {
        Point obj1 = new Point(10, 20);
        Point obj2 = obj1;
        System.out.printf("obj1 = (%d, %d) %n", obj1.x, obj1.y);
        System.out.printf("obj2 = (%d, %d) %n", obj2.x, obj2.y);
        obj2.x = 30;
        System.out.printf("obj1 = (%d, %d) %n", obj1.x, obj1.y);
		System.out.printf("obj2 = (%d, %d) %n", obj2.x, obj2.y);
	}
}
