import java.util.ArrayList;
import java.util.List;

public class PacificAtlantic {
	
	int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
	
	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> result = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;
		
		int m = matrix.length, n = matrix[0].length;
		boolean[][] pacific = new boolean[m][n];
		boolean[][] atlantic = new boolean[m][n];
		
		for (int i = 0; i < m; i++) {
			dfs(matrix, pacific, 0, i, 0);
			dfs(matrix, atlantic, 0, i, n - 1);
		}
		for (int i = 0; i < n; i++) {
			dfs(matrix, pacific, 0, 0, i);
			dfs(matrix, atlantic, 0, m - 1, i);
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (pacific[i][j] && atlantic[i][j])
					result.add(new int[] {i, j});
			}
		}
		return result;
	}
	
	private void dfs(int[][] matrix, boolean[][] visited, int height, int i, int j) {
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j] || matrix[i][j] < height) return;
		visited[i][j] = true;
		for (int[] dir : dirs) {
			dfs(matrix, visited, matrix[i][j], i + dir[0], j + dir[1]);
		}
	}

	public static void main(String[] args) {
		PacificAtlantic pa = new PacificAtlantic();
//		int[][] matrix = {{10,10,10},{10,1,10},{10,10,10}};
		int[][] matrix = {{1,2,3},{8,9,4},{7,6,5}};
//		int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
		for (int[] point : pa.pacificAtlantic(matrix)) {
			System.out.println(point[0] + ", " + point[1]);
		}
	}

}
