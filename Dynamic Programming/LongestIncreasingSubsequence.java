import java.util.Arrays;

public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		int len = 0;
		for (int num : nums) {
			// if num is not found, return -idx - 1
			// so for [2, 5], input 3, return -2. here -2 is reverted to 1 again to get the proper position
			// eventually this results in putting the smallest number at i that has the length of i + 1
			// The resulting dp may not be the correct LIS, but the invariant is that the last element of dp
			// is the tail of a LIS of length len + 1. See https://discuss.leetcode.com/topic/28738/java-python-binary-search-o-nlogn-time-with-explanation
			int idx = Arrays.binarySearch(dp, 0, len, num);
			if (idx < 0) idx = ~idx; // -(idx + 1);
			dp[idx] = num;
			if (idx == len) len++;
		}
		return len;
	}
	
	public static void main(String[] args) {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int[] nums = {10, 9, 2, 5, 6, 3, 7, 101, 18};
//		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		System.out.println(lis.lengthOfLIS(nums));
	}
}
