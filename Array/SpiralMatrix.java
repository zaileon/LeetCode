import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0) return result;
		int m = matrix.length, n = matrix[0].length;
		int left = 0, right = n - 1, top = 0, down = m - 1;
		while (left <= right && top <= down) {
			for (int i = left;  top <= down && i <= right; i++) 	result.add(matrix[top][i]);
			top++;
			for (int i = top;   left <= right && i <= down;  i++) 	result.add(matrix[i][right]);
			right--;
			for (int i = right; top <= down && i >= left;  i--) 	result.add(matrix[down][i]);
			down--;
			for (int i = down;  left <= right && i >= top;   i--) 	result.add(matrix[i][left]);
			left++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		SpiralMatrix sm = new SpiralMatrix();
//		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
//		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		for (int num : sm.spiralOrder(matrix)) {
			System.out.println(num);
		}
	}
}
