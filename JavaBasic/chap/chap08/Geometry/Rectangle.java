package chap08.Geometry;

public class Rectangle {
	public int width, height;

	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}
	int getArea(){
		return width*height;
	}
}
