
public class SearchMatrix {
	
	// treat the 2D matrix as a sorted array
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		int m = matrix.length, n = matrix[0].length;
		int lo = 0, hi = m * n - 1;
		while (lo != hi) {
			int mid = (lo + hi) >> 1;
			if (matrix[mid / n][mid % n] < target) lo = mid + 1;
			else hi = mid;
		}
		return matrix[hi / n][hi % n] == target;
	}
	
//	public boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix == null || matrix.length == 0) return false;
//		int m = matrix.length, n = matrix[0].length;
//		int lo = 0, hi = m - 1;
//		while (lo < hi) {
//			int mid = (lo + hi + 1) / 2;
//			if (target >= matrix[mid][0]) lo = mid;
//			else hi = mid - 1;
//		}
//		int row = lo;
//		lo = 0; hi = n - 1;
//		while (lo <= hi) {
//			int mid = (lo + hi) / 2;
//			if (target > matrix[row][mid]) lo = mid + 1;
//			else if (target < matrix[row][mid]) hi = mid - 1;
//			else return true;
//		}
//		return false;
//    }

	public static void main(String[] args) {
		SearchMatrix sm = new SearchMatrix();
		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		System.out.println(sm.searchMatrix(new int[][]{{}}, 1));
		System.out.println(sm.searchMatrix(matrix, 3));
		System.out.println(sm.searchMatrix(matrix, 13));
		System.out.println(sm.searchMatrix(matrix, 23));
		System.out.println(sm.searchMatrix(matrix, 35));
	}

}
