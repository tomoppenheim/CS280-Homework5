import java.text.DecimalFormat;
import java.util.*;

public class GPSCalculator {
	// Innerclass Waypoint
	public static class wayPoint{
		private double x = 0;
		private double y = 0;
		private int t = 0;
		
		public wayPoint(double xLoc, double yLoc, int time){
			x = xLoc;
			y = yLoc;
			t = time;
		}
		
		public void setX(double xLoc){
			x = xLoc;
		}
		
		public double getX(){
			return x;
		}
		
		public void setY(double yLoc){
			y = yLoc;
		}
		
		public double getY(){
			return y;
		}
		
		public void setT(int time){
			t = time;
		}
		
		public int getT(){
			return t;
		}
	}
	//wayPoint ends
	public static double calculateDistanceTraveled(wayPoint firstPoint, wayPoint lastPoint){
		double sideOne = firstPoint.getX() - lastPoint.getX();
		double sideTwo = firstPoint.getY() - lastPoint.getY();
		double sideThree = Math.sqrt((sideOne* sideOne) + (sideTwo* sideTwo));
		return sideThree;
	}
	
	public static void main(String args[]){
		Scanner keyboard = new Scanner(System.in);
		ArrayList<wayPoint> wayPoints = new ArrayList<wayPoint>();
		
		boolean notZero = true;
		while (notZero){
			System.out.println("Enter waypoint coordinates");
			System.out.println("X coordinate: ");
			double x = keyboard.nextDouble();
			if (x < 0){
				notZero = false;
				break;
			}
			System.out.println("Y coordinate: ");
			double y = keyboard.nextDouble();
			System.out.println("Time: ");
			int time = keyboard.nextInt();
			keyboard.nextLine();
			wayPoint point = new wayPoint(x, y, time);
			wayPoints.add(point);
		}
		
		double totalDistance = 0;
		int totalTime = 0;
		for (int i = 0; i < wayPoints.size()-1; i++){
			wayPoint one = wayPoints.get(i);
			wayPoint two = wayPoints.get(i+1);
			totalDistance += calculateDistanceTraveled(one, two);
			if (one.getT() > totalTime){
				totalTime = one.getT();
			}
			if (two.getT() > totalTime){
				totalTime = two.getT();
			}
		
		}
		totalDistance = totalDistance * .1;
		DecimalFormat df = new DecimalFormat("####0.00");
		System.out.println("Distance traveled: " + df.format(totalDistance) + "miles. ");
		System.out.println("Over: " + totalTime + " seconds.");
		System.out.println("Average Speed: " + df.format(totalDistance / (totalTime / 3600)) + " miles per hour");
		
	}
}
