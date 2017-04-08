package CHap16.NestedClass;

import java.awt.Point;

public class Line {
	Point point1, point2;
	Line(int x1, int y1, int x2, int y2){
		point1 = new Point(x1, y1);
		point2 = new Point(x2, y2);
	}
	void move(int offsetX, int offsetY){
		point1.x += offsetX;
		point1.x += offsetY;
		point2.x += offsetX;
		point2.x += offsetY;
	}
	static class Point {
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
