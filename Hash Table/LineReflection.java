import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LineReflection {

	public boolean isReflected(int[][] points) {
		if (points.length <= 1) return true;
		Map<Integer, Set<Integer>> coord = new HashMap<>();
		int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
		for (int[] p : points) {
			coord.putIfAbsent(p[0], new HashSet<Integer>());
			coord.get(p[0]).add(p[1]);
			minX = Math.min(minX, p[0]);
			maxX = Math.max(maxX, p[0]);
		}
		int sum = minX + maxX, k = 0;
		for (int key : coord.keySet()) {
			if (!coord.containsKey(sum - key)) return false;
			if (!coord.get(key).equals(coord.get(sum - key))) return false;
			if (++k > coord.size() / 2) break;
		}
		return true;
	}

	
	public static void main(String[] args) {
		LineReflection lr = new LineReflection();
//		int[][] points = {{1,1},{-1,-1}};
//		int[][] points = {{1,1},{-1,1}};
//		int[][] points = {{0,0},{0,0}};
		int[][] points = {{0,0},{1,0},{3,0}};
//		int[][] points = {{1,2},{2,2},{1,4},{2,4}};
//		int[][] points = {{-1,1},{1,1},{1,1}};
		System.out.println(lr.isReflected(points));
	}
}
