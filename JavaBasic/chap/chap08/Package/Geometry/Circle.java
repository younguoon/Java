package chap08.Package.Geometry;

public class Circle {
	int radius;

	Circle(int radius) {
		this.radius = radius;
	}
	double getArea(){
		return radius*radius*3.14;
	}

}
