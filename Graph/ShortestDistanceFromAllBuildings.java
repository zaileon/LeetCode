import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {

	static final int[] DIRECTION = {1,0,-1,0,1};
	int min = Integer.MAX_VALUE;
	public int shortestDistance(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int[][] distance = new int[m][n];
		int start = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					bfs(grid, distance, i, j, start--); // after BFS of start times, '0' becomes -start if it can be reached from all start buildings
				}
			}
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}
	
	private void bfs(int[][] grid, int[][] distance, int i, int j, int start) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i, j});
		int depth = 0;
		min = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			depth++;
			int sz = q.size();
			for (int s = 0; s < sz; s++) {
				int[] t = q.poll();
				for (int k = 0; k < 4; k++) {
					int x = t[0] + DIRECTION[k], y = t[1] + DIRECTION[k + 1];
					if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == start) {
						distance[x][y] += depth;
						min = Math.min(min, distance[x][y]);
						grid[x][y]--;
						q.offer(new int[]{x, y});
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		ShortestDistanceFromAllBuildings sd = new ShortestDistanceFromAllBuildings();
//		int[][] grid = {{0,2,1},{1,0,2},{0,1,0}}; // -1
//		int[][] grid = {{1}}; // -1
//		int[][] grid = {{1,2,0}}; // -1
//		int[][] grid = {{1,0,1,0,1}}; // -1
		int[][] grid = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}}; // 7
		System.out.println(sd.shortestDistance(grid));
	}
	
}
