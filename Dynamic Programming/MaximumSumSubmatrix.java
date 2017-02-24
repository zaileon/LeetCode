import java.util.TreeSet;

public class MaximumSumSubmatrix {

	// 2D Kadane's algorithm
	// Time complexity: O(M * M * N * lg N)
	// Space complexity: O(N)
	public int maxSumSubmatrix(int[][] matrix, int k) {
		int m = matrix.length, n = matrix[0].length;
		int result = Integer.MIN_VALUE;
		
		for (int left = 0; left < n; left++) {
		
			int[] nums = new int[m];
			
			for (int right = left; right < n; right++) {
				for (int i = 0; i < m; i++) 
					nums[i] += matrix[i][right];
				// use Kadane's algorithm to find the largest sum not more than k
				// complexity: O(NlgN)
				TreeSet<Integer> set = new TreeSet<>();
				set.add(0); // handle edge cases
				int sum = 0;
				for (int num : nums) {
					sum += num;
					Integer i = set.ceiling(sum - k); // find an integer slightly larger, so that sum -i <= k
					if (i != null) result = Math.max(result, sum - i);
					set.add(sum);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		MaximumSumSubmatrix mss = new MaximumSumSubmatrix();
		int[][] matrix = { {1,0,1}, {0,-2,3} }; int k = 2;
		System.out.println(mss.maxSumSubmatrix(matrix, k));
	}

}
