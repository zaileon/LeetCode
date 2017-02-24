
public class SpiralMatrixII {
	
	public int[][] generateMatrix(int n) {
		if (n < 0) return null;
		int[][] matrix = new int[n][n];
		int left = 0, right = n - 1, top = 0, down = n - 1, cnt = 1;
		while (n > 0) {
			for (int i = left; i <= right; i++) matrix[top][i] = cnt++;
			top++;
			for (int i = top; i <= down; i++) matrix[i][right] = cnt++;
			right--;
			for (int i = right; i >= left; i--) matrix[down][i] = cnt++;
			down--;
			for (int i = down; i >= top; i--) matrix[i][left] = cnt++;
			left++;
			n -= 2;
		}
		return matrix;
	}

	public static void main(String[] args) {
		SpiralMatrixII sm = new SpiralMatrixII();
		for (int[] row : sm.generateMatrix(4)) {
			for (int num : row) {
				System.out.print(num);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}

}
