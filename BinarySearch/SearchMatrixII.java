
public class SearchMatrixII {
	
	// think of the matrix like a BST, elements to the left are smaller, elements down are larger
	// time complexity is O(m+n)
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		int row = 0, col = matrix[0].length - 1;
		while (row < matrix.length && col >= 0) {
			if (target > matrix[row][col]) row++;
			else if (target < matrix[row][col]) col--;
			else return true;
		}
		return false;
	}

	public static void main(String[] args) {
		SearchMatrixII sm = new SearchMatrixII();
//		int[][] matrix = {
//				{ 1, 2, 3, 4, 5},
//				{ 6, 7, 8, 9,10},
//				{11,12,13,14,15},
//				{16,17,18,19,20},
//				{21,22,23,24,25}};
		int[][] matrix = {
				{1,   4,  7, 11, 15},
				{2,   5,  8, 12, 19},
				{3,   6,  9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}};
		System.out.println(sm.searchMatrix(matrix, 5)); // true;
		System.out.println(sm.searchMatrix(matrix, 20)); // false
		System.out.println(sm.searchMatrix(matrix, 30)); // true
		System.out.println(sm.searchMatrix(matrix, 25)); // false
	}

}
