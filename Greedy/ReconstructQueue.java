import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReconstructQueue {

	// sort people by height descending, then by count ascending
	// e.g. [7,0], [7,1], their counts should be exactly their indices as they count only each other
	// then when [6,1] comes in, we insert it into position 1
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
		List<int[]> queue = new LinkedList<>();
		for (int[] p : people) {
			queue.add(p[1], p);
		}
		return queue.toArray(new int[people.length][]);
	}
	
	public static void main(String[] args) {
		ReconstructQueue rq = new ReconstructQueue();
		int[][] people = {{7,0},{6,3},{7,1},{5,0},{6,1},{5,2}};
//		int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		int[][] queue = rq.reconstructQueue(people);
		for (int[] p : queue) {
			System.out.println(p[0] + "->" + p[1]);
		}
	}
}
