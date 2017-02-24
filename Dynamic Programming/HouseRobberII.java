
public class HouseRobberII {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
	}
	
	private int rob(int[] nums, int low, int hi) {
		int include = 0, exclude = 0;
		for (int j = low; j < hi; j++) {
			int i = include, e = exclude;
			include = nums[j] + e;
			exclude = Math.max(i, e);
		}
		return Math.max(include, exclude);
	}
}
