import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {
//	public int kthSmallest(int[][] matrix, int k) {
//		int n = matrix.length;
//		PriorityQueue<Tuple> pq = new PriorityQueue<>();
//		for (int i = 0; i < n; i++) pq.offer(new Tuple(0, i, matrix[0][i]));
//		while (--k > 0) {
//			Tuple t = pq.poll();
//			if (t.i < n - 1) pq.offer(new Tuple(t.i + 1, t.j, matrix[t.i + 1][t.j]));
//		}
//		return pq.poll().val;
//	}

	// binary search
	// one question is: how to make sure lo is actually an element in matrix?
	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		int lo = matrix[0][0], hi = matrix[n-1][n-1];
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			int i = 0, j = n - 1, count = 0;
			// sweep from top right to bottom left
			// for each row, find the first element <= mid, add the numbers of left elements to count
			// then start from the same col of next row, as if m[i][j+1] > mid, then m[i+1][j+1] must also >mid
			// so we only need to consider from col j to left
			while (i < n && j >= 0) {
				if (matrix[i][j] > mid) j--;
				else {
					count += j + 1;
					i++;
				}
			}
			// not enough elements, means that we have chosen lo too small
			if (count < k) lo = mid + 1;
			else hi = mid;
		}
		return lo;
	}
	
	public static void main(String[] args) {
		KthSmallestInSortedMatrix ks = new KthSmallestInSortedMatrix();
		int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}}; int k = 8;
		System.out.println(ks.kthSmallest(matrix, k));
	}
}

class Tuple implements Comparable<Tuple> {
	int i, j, val;
	Tuple(int x, int y, int v) { this.i = x; this.j = y; this.val = v; }
	
	@Override
	public int compareTo(Tuple t) {
		return this.val - t.val;
	}
}
