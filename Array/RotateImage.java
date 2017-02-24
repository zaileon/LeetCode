
public class RotateImage {
	public void rotateImage(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			rotateImageWithin(matrix, i, n - i - 1);
		}
	}
	
	private void rotateImageWithin(int[][] matrix, int start, int end) {
		for (int i = 0; i < end - start; i++) {
			int n = matrix[start][start + i];
			matrix[start][start + i] = matrix[end - i][start];
			matrix[end - i][start]   = matrix[end][end - i];
			matrix[end][end - i]     = matrix[start + i][end];
			matrix[start + i][end]   = n;
		}
	}
	
	public static void main(String[] args) {
		RotateImage ri = new RotateImage();
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		ri.rotateImage(matrix);
		for (int[] row : matrix) {
			for (int i : row) {
				System.out.print(i);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
}
