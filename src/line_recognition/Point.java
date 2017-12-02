package line_recognition;

import java.util.Comparator;

import princeton.lib.StdDraw;

public class Point implements Comparable<Point> {

	public final Comparator<Point> SLOPE_ORDER = new SOrder();

	private final int x;
	private final int y;

	public Point(int x, int y) {
		/* DO NOT MODIFY */
		this.x = x;
		this.y = y;
	}

	public void draw() {
		/* DO NOT MODIFY */
		StdDraw.point(x, y);
	}

	public void drawTo(Point that) {
		/* DO NOT MODIFY */
		StdDraw.line(this.x, this.y, that.x, that.y);
	}

	public double slopeTo(Point that) {
		if(x==that.x)
			if(y==that.y)
				return Double.NEGATIVE_INFINITY;
			else 
				return Double.POSITIVE_INFINITY;
		return ((double)y-that.y)/(x-that.x);
	}

	public int compareTo(Point that) {
		if(y<that.y)
			return -1;
		if(y>that.y)
			return 1;
		if(x<that.x)
			return -1;
		if(x>that.x)
			return 1;
		return 0;
	}

	private class SOrder implements Comparator<Point> {
		
		public int compare(Point p, Point q) {
			double slopeToP = Point.this.slopeTo(p);
			double slopeToQ = Point.this.slopeTo(q);
			if(slopeToP>slopeToQ)
				return 1;
			if(slopeToP<slopeToQ)
				return -1;
			return 0;
		}
	}

	public String toString() {
		/* DO NOT MODIFY */
		return "(" + x + ", " + y + ")";
	}
}