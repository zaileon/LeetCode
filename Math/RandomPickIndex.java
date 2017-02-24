
public class RandomPickIndex {
	
	java.util.Random random;
	int[] nums;
	
	public RandomPickIndex(int[] nums) {
		this.random = new java.util.Random();
		this.nums = nums;
	}
	
	public int pick(int target) {
		int count = 0, idx = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				if (random.nextInt(count + 1) == count) idx = i;
				count++;
			}
		}
		return idx;
	}

}
