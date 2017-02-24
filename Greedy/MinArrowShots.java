import java.util.Arrays;

public class MinArrowShots {

//	public int findMinArrowShots(int[][] points) {
//		Arrays.sort(points, (p1, p2) -> {
//			return p1[0] != p2[0] ? p1[0] - p2[0] : p2[1] - p1[1];
//		});
//        int arrows = 0, startItr = 0;
//        for (int i = 0; i < points.length; i = startItr) {
//        	int span = points[i][1];
//        	// shrink the right bound for all balloons in one shot
//            while (startItr < points.length && points[startItr][0] <= span) {
//            	if (points[startItr][1] < span) span = points[startItr][1];
//            	startItr++;
//            }
//            arrows++;
//        }
//        return arrows;
//	}
	
	public int findMinArrowShots(int[][] points) {
		if (points == null || points.length == 0) return 0;
		Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int arrows = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++) {
        	if (points[i][0] > end) {
        		arrows++;
        		end = points[i][1];
        	}
        }
        return arrows;
	}
	
	public static void main(String[] args) {
		MinArrowShots mas = new MinArrowShots();
		int[][] points = {{1,2},{3,4},{5,6},{7,8}}; // 4
//		int[][] points = {{Integer.MIN_VALUE, Integer.MAX_VALUE}}; // 2
//		int[][] points = {{1,6},{2,8},{7,12},{10,16}}; // 2
//		int[][] points = {{10,16},{2,8},{1,6},{7,12}}; // 2
//		int[][] points = {{1,2},{2,3},{3,4},{4,5}}; // 2
//		int[][] points = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}}; // 2
//		int[][] points = {{1,10},{3,9},{4,11},{6,7},{6,9},{8,12},{9,12}}; // 2
//		int[][] points = {}; // 2
		System.out.println(mas.findMinArrowShots(points));
	}

}
