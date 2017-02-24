
public class LongestIncreasingPath {

	public static final int[] DIRECTIONS = {1,0,-1,0,1};
	
	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		int m = matrix.length, n = matrix[0].length;
		int max = 1;
		int[][] memo = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, dfs(matrix, i, j, memo));
			}
		}
		return max;
	}
	
	private int dfs(int[][] matrix, int i, int j, int[][] memo) {
		if (memo[i][j] > 0) return memo[i][j];
		int len = 0;
		for (int k = 0; k < 4; k++) {
			int x = i + DIRECTIONS[k], y = j + DIRECTIONS[k + 1];
			if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[i][j])
				len = Math.max(len, dfs(matrix, x, y, memo));
		}
		memo[i][j] = len + 1;
		return memo[i][j];
	}
	
	public static void main(String[] args) {
		LongestIncreasingPath lip = new LongestIncreasingPath();
		int[][] matrix = {{3,4,5},{3,2,6},{2,2,1}};
//		int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
		System.out.println(lip.longestIncreasingPath(matrix));
	}

}
