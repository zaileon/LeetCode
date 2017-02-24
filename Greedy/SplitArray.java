
public class SplitArray {
	
	// cut nums into m subarrays so that the largest sum of subarray is minimal
	// the binary search: left bound is the maximum of numbers, right bound is the sum of numbers
	// if we can cut numbers into m pieces, each piece sums less than target, means mid/target is too small
	// if not, means target is too large
	public int splitArray(int[] nums, int m) {
		long sum = 0;
		int max = 0;
		for (int num : nums) {
			sum += num;
			max = Math.max(max, num);
		}
		return (int) binarySearch(nums, m, max, sum);
	}
	
	private long binarySearch(int[] nums, int m, long l, long r) {
		while (l < r) {
			long mid = (l + r) / 2;
			if (valid(nums, m, mid)) 
				r = mid;
			else
				l = mid + 1;
		}
		return r;
	}
	
	private boolean valid(int[] nums, int m, long target) {
		int sum = 0, count = 1;
		for (int num : nums) {
			sum += num;
			if (sum > target) {
				sum = num;
				count++;
				if (count > m) return false; // target too small
			}
		}
		return true; // target too large
	}
	
	public static void main(String[] args) {
		SplitArray sa = new SplitArray();
		int[] nums = {7,2,5,10,8}; int m = 2;
		System.out.println(sa.splitArray(nums, m));
	}
}
