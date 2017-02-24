package binary_indexed_tree;

public class NumMatrix {

	int[][] sums, matrix;
	int m, n;
	public NumMatrix(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) return;
		this.matrix = matrix;
		this.m = matrix.length;
		this.n = matrix[0].length;
		this.matrix = new int[m][n];
		this.sums = new int[m + 1][n + 1];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				update(i, j, matrix[i][j]);
			}
		}
	}
	
	public void update(int row, int col, int val) {
		if (m == 0 || n == 0) return;
		int diff = val - matrix[row][col];
		matrix[row][col] = val;
		for (int i = row + 1; i <= m; i += i & -i) {
			for (int j = col + 1; j <= n; j += j & -j) {
				sums[i][j] += diff;
			}
		}
	}
	
	public int sumRegion(int row1, int col1, int row2, int col2) {
		if (m == 0 || n == 0) return 0;
		return sum(row2 + 1, col2 + 1) - sum(row2 + 1, col1) - sum(row1, col2 + 1) + sum(row1, col1);
	}
	
	private int sum(int row, int col) {
		int sum = 0;
		for (int i = row; i > 0; i -= i & -i) {
			for (int j = col; j > 0; j -= j & -j) {
				sum += sums[i][j];
			}
		}
		return sum;
	}
}
