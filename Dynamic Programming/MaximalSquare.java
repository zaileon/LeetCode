public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		int m = matrix.length, n = matrix[0].length;
		int[] dp = new int[n+1];
		int maxSize = 0, pre = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				int temp = dp[j];
				if (matrix[i - 1][j - 1] == '1') {
					dp[j] = Math.min(dp[j], Math.min(dp[j - 1], pre)) + 1;
					maxSize = Math.max(maxSize, dp[j]);
				} else dp[j] = 0;
				pre = temp;
			}
		}
		return maxSize * maxSize;
	}
	
	public static void main(String[] args) {
		MaximalSquare ms = new MaximalSquare();
//		char[][] matrix = {
//				{'1', '0', '1', '0', '0'},
//				{'1', '0', '1', '1', '1'},
//				{'1', '1', '1', '1', '1'},
//				{'1', '0', '0', '1', '0'},
//		};
		char[][] matrix = {
				{'1', '0', '1', '1', '1'},
				{'0', '1', '0', '1', '0'},
				{'1', '1', '0', '1', '1'},
				{'1', '1', '0', '1', '1'},
				{'0', '1', '1', '1', '1'},
		};
//		char[][] matrix = {{'1'}};
		System.out.println(ms.maximalSquare(matrix));
	}
}
