import java.util.Arrays;

public class RelativeRanks {

	public String[] findRelativeRanks(int[] nums) {
		int N = nums.length;
		Integer[] idx = new Integer[N];
		for (int i = 0; i < N; i++) idx[i] = i;
		Arrays.sort(idx, (i, j) -> nums[j] - nums[i]);
		String[] result = new String[N];
		for (int i = 0; i < N; i++) {
			if (i == 0) result[idx[i]] = "Gold Medal";
			else if (i == 1) result[idx[i]] = "Silver Medal";
			else if (i == 2) result[idx[i]] = "Bronze Medal";
			else result[idx[i]] = String.valueOf(i + 1);
		}
		return result;
	}
	
	public static void main(String[] args) {
		RelativeRanks rr = new RelativeRanks();
		int[] nums = {3,5,2,4,1};
		String[] res = rr.findRelativeRanks(nums);
		for (String s : res) System.out.println(s);
	}
}
