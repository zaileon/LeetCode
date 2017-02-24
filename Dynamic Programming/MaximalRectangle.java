import java.util.Arrays;

public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		int m = matrix.length, n = matrix[0].length;
		int[] left = new int[n], right = new int[n], height = new int[n];
		Arrays.fill(right, n);
		int maxArea = 0;
		for (int i = 0; i < m; i++) {
			int cur_left = 0, cur_right = n;
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') 
					height[j]++; 
				else 
					height[j] = 0;
			}
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					// left[j] stores the left boundary
					// if '1', compare with left[j] in the previous row
					left[j] = Math.max(left[j], cur_left);
				} else {
					// if '0', reset left[j], move left boundary to the next right position
					left[j] = 0; cur_left = j + 1;
				}
			}
			for (int j = n - 1; j >= 0; j--) {
				if (matrix[i][j] == '1') {
					// right[j] stores the right boundary
					right[j] = Math.min(right[j], cur_right);
				} else {
					right[j] = n; cur_right = j;
				}
			}
			for (int j = 0; j < n; j++) {
				// (right - left) * h represents the max area which [i,j] resides
				maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
			}
		}
		return maxArea;
	}
	
	public static void main(String[] args) {
		MaximalRectangle mr = new MaximalRectangle();
		char[][] matrix = {
				{'1','0','1','0','0'},
				{'1','0','1','1','1'},
				{'1','1','1','1','1'},
				{'1','0','0','1','0'}
		};
		System.out.println(mr.maximalRectangle(matrix));
	}
}
