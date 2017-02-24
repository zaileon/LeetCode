import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        int[] result = {-1,-1};
		if (nums.length < 2) return result;
		Map<Integer, Integer> pos = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (pos.containsKey(target - nums[i])) 
				return new int[] { pos.get(target - nums[i]), i };
			pos.put(nums[i], i);
		}
		return result;
    }
}
