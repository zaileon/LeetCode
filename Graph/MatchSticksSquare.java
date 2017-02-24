import java.util.Arrays;

public class MatchSticksSquare {
	
	public boolean makesquare(int[] nums) {
		if (nums.length < 4) return false;
		int sum = 0;
		for (int num : nums) sum += num;
		if (sum % 4 != 0) return false;
		
		Arrays.sort(nums);
		reverse(nums);
		
		return dfs(nums, new int[4], 0, sum / 4);
	}
	
	private void reverse(int[] nums) {
		for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
	}

	private boolean dfs(int[] nums, int[] sums, int idx, int target) {
		if (idx == nums.length) {
			return sums[0] == target && sums[1] == target && sums[2] == target;
		}
		for (int i = 0; i < 4; i++) {
			if (sums[i] + nums[idx] > target) continue; // nums are reversed, so can quickly eliminate nums[idx] for the side being examined
			int j = 0; // optimization 2: if this side has the same length as some previous side, we don't need to check it again
			while (j < i) {
				if (sums[j] == sums[i]) break;
				j++;
			}
			if (j < i) continue;
			sums[i] += nums[idx];
			if (dfs(nums, sums, idx + 1, target)) return true;
			sums[i] -= nums[idx];
		}
		return false;
	}
	
	public static void main(String[] args) {
		MatchSticksSquare mss = new MatchSticksSquare();
		int[] nums = {1,2,3,4,5,6,7,8,9,10,5,4,3,2,1};
//		int[] nums = {3,3,3,3,4};
//		int[] nums = {1,1,2,2,2};
		System.out.println(mss.makesquare(nums));
	}

}
