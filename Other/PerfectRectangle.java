import java.util.HashSet;
import java.util.Set;

public class PerfectRectangle {
	
	public boolean isRectangleCover(int[][] rectangles) {
		if (rectangles == null || rectangles.length == 0 || rectangles[0].length != 4) return false;
		
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;
		
		Set<String> set = new HashSet<>();
		int area = 0;
		
		for (int[] rect : rectangles) {
			area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
			
			minX = Math.min(minX, rect[0]);
			maxX = Math.max(maxX, rect[2]);
			minY = Math.min(minY, rect[1]);
			maxY = Math.max(maxY, rect[3]);
			
			String bottomLeft  = rect[0] + " " + rect[1];
			String topLeft     = rect[0] + " " + rect[3];
			String bottomRight = rect[2] + " " + rect[1];
			String topRight    = rect[2] + " " + rect[3];
			
			if (!set.add(bottomLeft)) 	set.remove(bottomLeft);
			if (!set.add(topLeft)) 		set.remove(topLeft);
			if (!set.add(bottomRight)) 	set.remove(bottomRight);
			if (!set.add(topRight)) 	set.remove(topRight);
		}
		
		if (!set.contains(minX + " " + minY) || !set.contains(minX + " " + maxY) || !set.contains(maxX + " " + minY) || !set.contains(maxX + " " + maxY) || set.size() != 4) return false;
		return area == (maxX - minX) * (maxY - minY);
	}
	
	public static void main(String[] args) {
		PerfectRectangle pr = new PerfectRectangle();
		int[][] rectangles = {{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
		System.out.println(pr.isRectangleCover(rectangles));
	}
}
