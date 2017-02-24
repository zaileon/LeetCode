public class NumberOfIslands {
	// BFS solution
//	public int numIslands(char[][] grid) {
//		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
//		int m = grid.length, n = grid[0].length;
//		boolean[][] visited = new boolean[m][n];
//		Deque<int[]> queue = new ArrayDeque<>();
//		int num = 0;
//		int[][] shifts = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//		
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				if (!visited[i][j] && grid[i][j] == '1') {
//					num++;
//					queue.add(new int[] {i, j});
//					visited[i][j] =	true;
//					bfs(grid, visited, queue, shifts);
//				}
//				
//			}
//		}
//		
//		return num;
//	}
//	
//	private void bfs(char[][] grid, boolean[][] visited, Deque<int[]> queue, int[][] shifts) {
//		while (!queue.isEmpty()) {
//			int[] coordinate = queue.removeFirst();
//			for (int[] shift : shifts) {
//				int x = coordinate[0] + shift[0], y = coordinate[1] + shift[1];
//				if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !visited[x][y] && grid[x][y] == '1') {
//					visited[x][y] = true;
//					queue.add(new int[] { x, y });
//				}
//			}
//		}
//	}
	
	// DFS solution: sink the island
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		int m = grid.length, n = grid[0].length;
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				count += dfs(grid, i, j);
			}
		}
		return count;
	}
	
	private int dfs(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return 0;
		grid[i][j] = '0';
		dfs(grid, i + 1, j);
		dfs(grid, i - 1, j);
		dfs(grid, i, j + 1);
		dfs(grid, i, j - 1);
		return 1;
	}
	
	public static void main(String[] args) {
		NumberOfIslands noi = new NumberOfIslands();
		char[][] grid = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
//		char[][] grid = {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
		System.out.println(noi.numIslands(grid));
	}
}
