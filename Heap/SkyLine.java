import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class SkyLine {
	
	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> points = new ArrayList<>();
		for (int[] building : buildings) {
			points.add(new int[] { building[0], -building[2] }); // start point
			points.add(new int[] { building[1], building[2] }); //  end point
		}
		Collections.sort(points, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p1[0] - p2[0]);
		
		List<int[]> result = new ArrayList<>();
		TreeMap<Integer, Integer> heights = new TreeMap<>();
		heights.put(0, 1);
		int prev = 0;
		
		// Use a heap to keep track of the heights of all current valid buildings
		// If it's a start(point[1]<0), enqueue it, if it's a end, dequeue
		// PriorityQueue's remove take O(n), so use TreeMap instead
		// Negative height can make sure that for the same building, start < end
		// Also for two adjacent buildings, the one ending at x will be placed behind the one starting from x
		for (int[] point : points) {
			if (point[1] < 0) {
				int count = heights.getOrDefault(-point[1], 0);
				heights.put(-point[1], count + 1);
			} else {
				heights.put(point[1], heights.get(point[1]) - 1);
				if (heights.get(point[1]) == 0) heights.remove(point[1]);
			}
			int curr = heights.lastKey();
			if (curr != prev) {
				result.add(new int[] { point[0], curr });
				prev = curr;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		SkyLine sl = new SkyLine();
		int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
		for (int[] point : sl.getSkyline(buildings)) {
			System.out.println(point[0] + "->" + point[1]);
		}
	}

}
