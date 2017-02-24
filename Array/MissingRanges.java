import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> result = new ArrayList<>();
		if (lower > upper) return result;
		long start = lower;
		for (int i = 0; i < nums.length; i++) {
			long end = (long)nums[i] - 1;
			if (start <= end) result.add(getRange(start, end));
			start = (long)nums[i] + 1;
		}
		if (start <= upper) result.add(getRange(start, upper));
		return result;
	}
	
	private String getRange(long start, long end) {
		return start == end ? start + "" : start + "->" + end;
	}
	
	public static void main(String[] args) {
		MissingRanges mr = new MissingRanges();
//		int[] nums = {Integer.MAX_VALUE}; int lower = 0, upper = Integer.MAX_VALUE;
		int[] nums = {Integer.MIN_VALUE, Integer.MAX_VALUE}; int lower = Integer.MIN_VALUE, upper = Integer.MAX_VALUE;
//		int[] nums = {1}; int lower = 0, upper = 99;
//		int[] nums = {0,1,3,50,98,99}; int lower = 0, upper = 99;
		for (String range : mr.findMissingRanges(nums, lower, upper)) {
			System.out.println(range);
		}
	}
}
