import java.util.Arrays;

public class CombinationSumIV {
	// bottom up
//	public int combinationSum4(int[] nums ,int target) {
//		Arrays.sort(nums);
//		int[] dp = new int[target + 1];
//		dp[0] = 1;
//		for (int i = 1; i <= target; i++) {
//			for (int j = 0; j < nums.length && nums[j] <= i; j++) {
//				dp[i] += dp[i - nums[j]];
//			}
//		}
//		return dp[target];
//	}
	
	// top down. might be faster if the elements can quickly reduce target to zero
	// in contrast to slowly build up to target from 0 in the bottom up method
	private int[] dp;
	public int combinationSum4(int[] nums ,int target) {
		dp = new int[target + 1];
		Arrays.fill(dp, -1);
		dp[0] = 1;
		return helper(nums, target);
	}
	
	private int helper(int[] nums, int target) {
		if (dp[target] != -1) return dp[target];
		int res = 0;
		for (int num : nums) {
			if (target >= num) res += helper(nums, target - num);
		}
		dp[target] = res;
		return res;
	}
	
	public static void main(String[] args) {
		CombinationSumIV cs = new CombinationSumIV();
//		int[] nums = {}; int target = 1;
		int[] nums = {1,2,3}; int target = 4;
		System.out.println(cs.combinationSum4(nums, target));
	}
}
