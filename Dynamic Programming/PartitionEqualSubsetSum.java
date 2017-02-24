public class PartitionEqualSubsetSum {
	public boolean canPartition(int[] nums) {
		if (nums == null || nums.length < 2) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum & 1) != 0) return false;
        sum /= 2;
		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;
		// find a list of numbers that sum to half of the total sum
		for (int i = 0; i < nums.length; i++) {
			for (int j = sum; j >= nums[i]; j--) {
				dp[j] = dp[j] || dp[j - nums[i]];
				if (j == sum && dp[j]) return true;
			}
		}
		return false;
    }
	
	public static void main(String[] args) {
		PartitionEqualSubsetSum pess = new PartitionEqualSubsetSum();
//		int[] nums = {1, 3, 4, 4};
//		int[] nums = {1, 2};
		int[] nums = {1, 2, 3, 4, 6};
//		int[] nums = {1, 2, 3, 5};
//		int[] nums = {1,5,5,11};
		System.out.println(pess.canPartition(nums));
	}
}
