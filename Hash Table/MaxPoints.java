import java.util.HashMap;
import java.util.Map;

public class MaxPoints {

	// for every point, count the rate of lines passing through it and every other point
	// after we start from x and count y, we don't need to consider x when start from y
	// we only need to consider from y to the rest points that may yield maximum 
	public int maxPoints(Point[] points) {
		Map<Long, Integer> count = new HashMap<>();
		int result = 0;
		for (int i = 0; i < points.length; i++) {
			count.clear();
			int max = 0, overlap = 0;
			for (int j = i + 1; j < points.length; j++) {
				int x = points[j].x - points[i].x;
				int y = points[j].y - points[i].y;
				if (x == 0 && y == 0) { // the same as points[i]
					overlap++;
					continue;
				}
				int gcd = gcd(x, y);
				if (gcd != 0) { // gcd using Euclidean algorithm can be positive, negative or zero
					x /= gcd; y /= gcd;
				}
				long key = ((long) x << 32) | y; // use long as key to avoid nested map
				int cnt = count.getOrDefault(key, 0) + 1;
				max = Math.max(max, cnt);
				count.put(key, cnt);
			}
			result = Math.max(result, max + overlap + 1);
		}
		return result;
	}
	
	
	private int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}
	
	public static void main(String[] args) {
		MaxPoints mp = new MaxPoints();
		Point[] points = new Point[] { new Point() };
		System.out.println(mp.maxPoints(points));
	}
}

class Point {
	int x, y;
	public Point() { x = 0; y = 0; }
	public Point(int a, int b) { x = a; y = b; }
}