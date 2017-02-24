public class SlidingWindowMaximum {
	
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (k <= 0) return new int[] {};
		int n = nums.length;
		int[] result = new int[n - k + 1];
		// Use an array to implement Deque which keeps the indices of nums
		int[] q = new int[n];
		int start = 0, end = 0;
		for (int i = 0; i < n; i++) {
			// Remove the first element if it lies beyond the range[i - k + 1, i]
			if (end > start && q[start] < i - k + 1) start++;
			// keep popping from back elements that are smaller than nums[i]
			while (end > start && nums[q[end - 1]] < nums[i]) end--;
			q[end++] = i;
			// The first element of deque is always the largest  
			if (i >= k - 1) result[i - k + 1] = nums[q[start]];
		}
		return result;
	}

	public static void main(String[] args) {
		SlidingWindowMaximum swm = new SlidingWindowMaximum();
		int k = 3; int[] nums = {1,3,5,-3,5,3,6,7};
//		int k = 0; int[] nums = {};
		for (int num : swm.maxSlidingWindow(nums, k)) {
			System.out.println(num);
		}
	}
}
