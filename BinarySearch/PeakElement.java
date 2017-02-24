
public class PeakElement {
	public int findPeakElement(int[] nums) {
		if (nums.length == 0) return -1;
		int lo = 0, hi = nums.length - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (mid < nums.length - 1 && nums[mid] < nums[mid + 1]) lo = mid + 1;
			else if (mid > 0 && nums[mid] < nums[mid - 1]) hi = mid - 1;
			else return mid;
		}
		return lo;
	}
	
	public static void main(String[] args) {
		PeakElement pe = new PeakElement();
//		int[] nums = {4,3,2,1};
//		int[] nums = {2,3,5,9};
		int[] nums = {1,2};
//		int[] nums = {1};
//		int[] nums = {2,1};
//		int[] nums = {1,2,3,1};
		System.out.println(pe.findPeakElement(nums));
	}
}
