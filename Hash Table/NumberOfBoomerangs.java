import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {
	public int numberOfBoomerangs(int[][] points) {
        int n = points.length, sum = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
            	if (j != i) {
	                int dist2 = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + 
	                            (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
	                count.put(dist2, count.getOrDefault(dist2, 0) + 1);
            	}
            }
            for (int v : count.values()) {
            	sum += v * (v - 1);
            }
            count.clear();
        }
        return sum;
    }
	
	public static void main(String[] args) {
		NumberOfBoomerangs nob = new NumberOfBoomerangs();
		int[][] points = {{0,0},{1,0},{2,0}};
		System.out.println(nob.numberOfBoomerangs(points));
	}
}
