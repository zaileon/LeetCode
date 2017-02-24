
public class SetZeroes {
	
	// To do the operation in place, set m[0][j] and m[i][0] to 0 if m[i][j] = 0
	// but first check if i == 0 (the firstRow should all be 0) or j == 0 (the firstCol should all be 0)
	public void setZeroes(int[][] matrix) {
		boolean firstRow = false, firstCol = false;
		int m = matrix.length, n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) { 
					if (i == 0) firstRow = true;
					if (j == 0) firstCol = true;
					matrix[i][0] = matrix[0][j] = 0;
				}
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) 
					matrix[i][j] = 0;
			}
		}
		if (firstRow) for (int i = 0; i < n; i++) matrix[0][i] = 0;
		if (firstCol) for (int i = 0; i < m; i++) matrix[i][0] = 0;
	}
	
	public static void main(String[] args) {
		SetZeroes sz = new SetZeroes();
		int[][] matrix = {{1,1},{1,0}};
		sz.setZeroes(matrix);
	}
}