
public class DiagonalTraversal {
	
	public int[] findDiagonalOrder(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
		int m = matrix.length, n = matrix[0].length;
		int[] res = new int[m * n];
		int k = 0;
		for (int level = 0; level <= m + n - 2; level++) {
			int start = level % 2 == 0 ? Math.min(level, m - 1) : Math.max(level - n + 1, 0);
			int end   = level % 2 == 0 ? Math.max(level - n, -1) : Math.min(level + 1, m);
			int step  = level % 2 == 0 ? -1 : 1;
			for (int i = start; i != end; i += step) {
				res[k++] = matrix[i][level - i];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		DiagonalTraversal dt = new DiagonalTraversal();
		int[][] matrix = {{1,2,3,4},{5,6,7,8}};
//		int[][] matrix = {{1,2},{3,4},{5,6},{7,8}};
		int[] res = dt.findDiagonalOrder(matrix);
		for (int n : res) {
			System.out.println(n);
		}
	}

}
