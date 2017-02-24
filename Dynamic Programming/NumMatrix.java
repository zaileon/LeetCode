
public class NumMatrix {
    int[][] sums;
    public NumMatrix(int[][] matrix) {
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length, n = matrix[0].length;
        sums = new int[m][n];
        int[] partials = new int[n];
        for (int j = 0; j < n; j++) {
        	partials[j] = matrix[0][j];
        	sums[0][j] = j == 0 ? partials[0] : sums[0][j-1] + partials[j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) partials[j] += matrix[i][j];
            sums[i][0] = partials[0];
            for (int j = 1; j < n; j++) sums[i][j] = sums[i][j-1] + partials[j];
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int up = row1 == 0 ? 0 : sums[row1-1][col2];
        int left = col1 == 0 ? 0 : sums[row2][col1-1];
        int upLeft = (row1 == 0 || col1 == 0) ? 0 : sums[row1-1][col1-1];
        return sums[row2][col2] - up - left + upLeft;
    }
    
    public static void main(String[] args) {
    	int[][] matrix = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
//    	int[][] matrix = {{-1}};
    	NumMatrix nm = new NumMatrix(matrix);
    	System.out.println(nm.sumRegion(2, 1, 4, 3));
    	System.out.println(nm.sumRegion(1, 1, 2, 2));
    	System.out.println(nm.sumRegion(1, 2, 2, 4));
//    	System.out.println(nm.sumRegion(0, 0, 0, 0));
	}
}