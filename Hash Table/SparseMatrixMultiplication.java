public class SparseMatrixMultiplication {

	public int[][] multiple(int[][] A, int[][] B) {
		int m = A.length, n = A[0].length, nb = B[0].length;
		int[][] C = new int[m][nb];
		for (int i = 0; i < m; i++) {
			for (int k = 0; k < n; k++) {
				if (A[i][k] != 0) {
					for (int j = 0; j < nb; j++) {
						if (B[k][j] != 0) C[i][j] += A[i][k] * B[k][j];
					}
				}
			}
		}
		return C;
	}
	
	public static void main(String[] args) {
		SparseMatrixMultiplication smm = new SparseMatrixMultiplication();
		int[][] A = {{1,0,0},{-1,0,3}}, B = {{7,0,0},{0,0,0},{0,0,1}};
		int[][] C = smm.multiple(A, B);
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < C[0].length; j++) {
				System.out.print(C[i][j]);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}

}
