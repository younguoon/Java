package chap08.Package.Geometry;

import chap08.Package.Geometry2.Rectangle;

public class PackageExample3 {
	public static void main(String[] args) {
	chap08.Package.Geometry2.Rectangle obj = new chap08.Package.Geometry2.Rectangle(2, 3);
	Rectangle obj2 = new Rectangle(2,3);
	System.out.println("���� : "+obj.width);
	System.out.println("���� : "+obj.height);
	System.out.println("���� : "+obj.getArea());
	}
}
