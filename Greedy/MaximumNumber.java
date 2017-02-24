
public class MaximumNumber {
	
	// there should be a suffix array solution after running maxArray(nums1, k) and maxArray(nums2, k) 
	// instead of doing merge/compare operation
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int n = nums1.length, m = nums2.length;
		int[] ans = new int[k];
		for (int i = Math.max(k / 2, k - m); i <= k && i <= n; i++) {
			int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
			if (greater(candidate, 0, ans, 0)) ans = candidate;
		}
		return ans;
	}
	
	// This is an alternative implementation of stack
	// see explanation https://discuss.leetcode.com/topic/36805/c-16ms-fastest-beats-97
	public int[] maxArray(int[] nums, int k) {
		int[] ans = new int[k];
		int n = nums.length;
		// i, j points to the positions in nums, ans respectively
		for (int i = 0, j = 0; i < nums.length; i++) {
			// the # of numbers remaining in nums is n - i, the # of slots remaining in ans is k - j (i,j unchecked/unfilled)
			// if we have enough numbers left, e.g. n-i > k-j, and the current nums[i] is greater than the last number in ans (ans[j-1])
			// we keep going back until we found the j whose prev number is greater than nums[i], and put nums[i] at j
			while (n - i > k - j && j > 0 && ans[j - 1] < nums[i]) j--;
			if (k - j > 0) ans[j++] = nums[i];
		}
		return ans;
	}
	
	// for each digit, compare and pick the larger among nums1[i...] and nums2[j...]
	public int[] merge(int[] nums1, int[] nums2, int k) {
		int[] ans = new int[k];
		for (int i = 0, j = 0, r = 0; r < k; r++) {
			ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
		}
		return ans;
	}
	
	// greater or equal
	public boolean greater(int[] nums1, int i, int[] nums2, int j) {
		while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
			i++; j++;
		}
		// does the following two conditions cover all the possibilities?
		return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
	}
	
	public static void main(String[] args) {
		MaximumNumber mn = new MaximumNumber();
		int[] nums1 = {3,4,6,5}, nums2 = {9,1,2,5,8,3}; int k = 5;
		for (int num : mn.maxNumber(nums1, nums2, k)) {
			System.out.println(num);
		}
		
	}
}
