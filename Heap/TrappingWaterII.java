import java.util.PriorityQueue;

public class TrappingWaterII {

	// Similar to the one dimension problem, maintain a boundary
	// every time get a boundary point (lowest point in the heap), if the neighbor is unvisited and lower, it's guaranteed to hold (c.h - neighbor.h)
	// the trick part is modify the neighbor height to c.h
	public int trappingWater(int[][] heightMap) {
		if (heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2) return 0;
		PriorityQueue<Cell> heap = new PriorityQueue<Cell>();
		int m = heightMap.length, n = heightMap[0].length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < n; i++) {
			visited[0][i] = true;      heap.offer(new Cell(0, i, heightMap[0][i]));
			visited[m - 1][i] = true;  heap.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
		}
		for (int i = 1; i < m - 1; i++) {
			visited[i][0] = true;		heap.offer(new Cell(i, 0, heightMap[i][0]));
			visited[i][n - 1] = true;   heap.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
		}
		int total = 0;
		int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
		while (!heap.isEmpty()) {
			Cell c = heap.poll();
			for (int[] dir : dirs) {
				int row = c.row + dir[0];
				int col = c.col + dir[1];
				if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
					total += Math.max(0, c.height - heightMap[row][col]); // this part is like one-dimension problem
					visited[row][col] = true;
					heap.offer(new Cell(row, col, Math.max(heightMap[row][col], c.height))); // !!
				}
			}
		}
		return total;
	}
	
	class Cell implements Comparable<Cell> {
		int row, col, height;
		Cell(int r, int c, int h) { row = r; col = c; height = h; }
		@Override
		public int compareTo(Cell o) { return this.height - o.height; }
	}
	
	public static void main(String[] args) {
		TrappingWaterII tw = new TrappingWaterII();
		int[][] heightMap = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
		System.out.println(tw.trappingWater(heightMap)); // 4
	}
}
