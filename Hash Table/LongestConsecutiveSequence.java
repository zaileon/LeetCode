import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
	
	// keep track of the sequence length and store that in the boundary points of the sequence
	// for sequence {1,2,3,4,5}, get(1) and get(5) both return 5, but get(2), if exists, might not return 5
	public int longestConsecutive(int[] nums) {
		Map<Integer, Integer> boundaries = new HashMap<>();
		int max = 0;
		for (int num : nums) {
			if (!boundaries.containsKey(num)) {
				// see if n-1 and n+1 exist. since there is no duplicate, there can only be two cases:
				// n-1 and n+1 are boundary points of two different sequences
				// either n-1 or n+1 (can be both) doesn't exist, n extends one sequence or a standalone point
				int left  = boundaries.containsKey(num - 1) ? boundaries.get(num - 1) : 0;
				int right = boundaries.containsKey(num + 1) ? boundaries.get(num + 1) : 0;
				int sum = left + right + 1;
				max = Math.max(max, sum);
				boundaries.put(num, sum);
				// update the boundaries, the points in the middle don't matter
				boundaries.put(num - left, sum);
				boundaries.put(num + right, sum);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		int[] nums = {1,3,5,2,6,4,7};
		System.out.println(lcs.longestConsecutive(nums));
	}

}
