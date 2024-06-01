package algoJV.dos;

import lib.Point2D;
import lib.StdDraw;
import lib.StdOut;
import lib.StdRandom;

public class Ex1 {
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Point2D[] points = new Point2D[n];
		
		drawAndCreatePoints(points);
		
		StdOut.printf("The shortest distance is: %.3f", calculateShortestDistance(points));
		
	}
	
	private static void drawAndCreatePoints(Point2D[] points) {
		StdDraw.setCanvasSize(780, 640);
		StdDraw.setPenRadius(0.05);
		StdDraw.setScale(0, 1);
		
		for (int i = 0; i < points.length; i++) {
			double pointX = StdRandom.uniformDouble();
			double pointY = StdRandom.uniformDouble();
			
			Point2D point = new Point2D(pointX, pointY);
			StdDraw.point(point.x(), point.y());
			
			points[i] = point;
		}
	}
		
	public static double calculateShortestDistance(Point2D[] points) {
		double shortestDistance = Double.MAX_VALUE;
		double currDistance;
		
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				currDistance = points[i].distanceTo(points[j]);
				if (currDistance < shortestDistance) shortestDistance = currDistance;
			}
		}
		
		return shortestDistance;
	}
}
