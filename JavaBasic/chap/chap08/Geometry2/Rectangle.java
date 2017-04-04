package chap08.Geometry2;

public class Rectangle {
	public int width, height;

	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}
	public int getArea(){
		return width*height;
	}
}
