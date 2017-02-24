import java.util.HashMap;

public class MaximumSubarrayLength {
	public int maxSubArrayLen(int[] nums ,int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0, len = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum == k) // the length (i+1) must be greater than len so far
				len = i + 1;
			else if (map.containsKey(sum - k))
				len = Math.max(len, i - map.get(sum - k));
			// only keep the smallest possible for map[sum]
			if (!map.containsKey(sum))
				map.put(sum, i);
		}
		return len;
	}

	public static void main(String[] args) {
		MaximumSubarrayLength msl = new MaximumSubarrayLength();
		int[] nums = {1, 0, -1}; int k = -1;
//		int[] nums = {1, -1, 5, -2, 3}; int k = 3;
		System.out.println(msl.maxSubArrayLen(nums, k));
	}

}
