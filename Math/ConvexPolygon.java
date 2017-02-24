import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvexPolygon {
	
	public boolean isConvex(List<List<Integer>> points) {
		if (points.size() <= 3) return true;
		int n = points.size();
		boolean isNegative = false, isPositive = false;
		for (int i = 0; i < n; i++) {
			int c = rotate(points.get(i), points.get((i + 1) % n), points.get((i + 2) % n));
			if (c > 0) isPositive = true;
			if (c < 0) isNegative = true;
			if (isPositive && isNegative) return false;
		}
		return true;
	}
	
	private int rotate(List<Integer> p1, List<Integer> p2, List<Integer> p3) {
		int x1 = p2.get(0) - p1.get(0);
		int y1 = p2.get(1) - p1.get(1);
		int x2 = p3.get(0) - p2.get(0);
		int y2 = p3.get(1) - p2.get(1);
		return x1 * y2 - x2 * y1;
	}
	
	public static void main(String[] args) {
		ConvexPolygon cp = new ConvexPolygon();
		List<List<Integer>> points = new ArrayList<>();
//		points.add(Arrays.asList(0, 0));
//		points.add(Arrays.asList(0, 10));
//		points.add(Arrays.asList(10, 10));
//		points.add(Arrays.asList(10, -10));
//		points.add(Arrays.asList(-10, -10));
//		points.add(Arrays.asList(-10, 0));
//		points.add(Arrays.asList(5, 5));
		points.add(Arrays.asList(0, 1907));
		points.add(Arrays.asList(6, 952));
		points.add(Arrays.asList(12, 29));
//		points.add(Arrays.asList(376, 23));
//		points.add(Arrays.asList(1217, 10));
//		points.add(Arrays.asList(2622, 2));
//		points.add(Arrays.asList(9260, 5));
//		points.add(Arrays.asList(9729, 33));
//		points.add(Arrays.asList(9977, 111));
//		points.add(Arrays.asList(9995, 3692));
//		points.add(Arrays.asList(9984, 8244));
		System.out.println(cp.isConvex(points));
	}
}
