import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
	
	// DFS perform better in Leetcode
	// There is a comparison https://discuss.leetcode.com/topic/35242/benchmarks-of-dfs-and-bfs/2
	public void wallsAndGates(int[][] rooms) {
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0) dfs(rooms, i, j, 0);
			}
		}
	}
	
	private void dfs(int[][] rooms, int i, int j, int d) {
		if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < d) return;
		rooms[i][j] = d;
		dfs(rooms, i + 1, j, d + 1);
		dfs(rooms, i - 1, j, d + 1);
		dfs(rooms, i, j + 1, d + 1);
		dfs(rooms, i, j - 1, d + 1);
	}
	
	// Multiend BFS
//	public void wallsAndGates(int[][] rooms) {
//		if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
//		int m = rooms.length, n = rooms[0].length;
//		int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
//		Queue<Integer> queue = new LinkedList<>();
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				if (rooms[i][j] == 0) queue.offer(i * n + j);
//			}
//		}
//		while (!queue.isEmpty()) {
//			int k = queue.poll(), x0 = k / n, y0 = k % n;
//			for (int[] dir : dirs) {
//				int x = x0 + dir[0], y = y0 + dir[1];
//				if (x >= 0 && x < m && y >= 0 && y < n && rooms[x][y] == Integer.MAX_VALUE) {
//					rooms[x][y] = rooms[x0][y0] + 1;
//					queue.offer(x * n + y);
//				}
//			}
//		}
//	}
	
	public static void main(String[] args) {
		WallsAndGates wag = new WallsAndGates();
		int[][] rooms = {
				{Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
				{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,-1},
				{Integer.MAX_VALUE,-1,Integer.MAX_VALUE,-1},
				{0,-1,Integer.MAX_VALUE,Integer.MAX_VALUE}
		};
		wag.wallsAndGates(rooms);
		for (int[] row : rooms) {
			for (int i : row) {
				System.out.print(i + " ");
			}
			System.out.println("");
		}
	}
}
