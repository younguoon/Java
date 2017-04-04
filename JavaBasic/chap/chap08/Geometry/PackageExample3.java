package chap08.Geometry;

import chap08.Geometry2.Rectangle;

public class PackageExample3 {
	public static void main(String[] args) {
	chap08.Geometry2.Rectangle obj = new chap08.Geometry2.Rectangle(2, 3);
	Rectangle obj2 = new Rectangle(2,3);
	System.out.println("넓이 : "+obj.width);
	System.out.println("높이 : "+obj.height);
	System.out.println("면적 : "+obj.getArea());
	}
}
