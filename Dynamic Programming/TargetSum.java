public class TargetSum {

	// This problem can be decomposed into assigning some numbers to Positive set(P), and the the rest to Negative set(N)
	// P + N = Sum, P - N = S, so 2 * P = Sum + S, we can return 0 for any S that Sum + S is odd
	// The problem is to pick some numbers that add up to (Sum + S) / 2 
	// Remember how the subset sum is done (!!!)
	public int findTargetSumWays(int[] nums, int S) {
		int sum = 0;
		for (int num : nums)
			sum += num;
		if (S > sum || ((S + sum) & 1) != 0) 
			return 0;
		int s = (S + sum) >>> 1;
		int[] dp = new int[s + 1];
		dp[0] = 1;
		for (int num : nums)
			for (int i = s; i >= num; i--)
				dp[i] += dp[i - num];
		return dp[s];
	}
	
	public static void main(String[] args) {
		TargetSum ts = new TargetSum();
		int[] nums = {1,2,3,4,5}; int S = 7;
//		int[] nums = {1,1,1,1,1}; int S = 3;
		System.out.println(ts.findTargetSumWays(nums, S));
	}
}
