
public class FindMinimumInRotatedArrayII {
	
	// When nums[mid] == nums[hi], we can't be sure. So just reduce hi
	public int findMin(int[] nums) {
		int lo = 0, hi = nums.length - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] < nums[hi]) hi = mid;
			else if (nums[mid] > nums[hi]) lo = mid + 1;
			else {
				if (nums[hi] < nums[hi-1]) { lo = hi; break; } // this line can be added to find the offset
				hi--;
			}
		}
		return nums[lo];
	}

	public static void main(String[] args) {
		FindMinimumInRotatedArrayII fmra = new FindMinimumInRotatedArrayII();
		System.out.println(fmra.findMin(new int[] {2,3,1,2,2,2,2}));
		System.out.println(fmra.findMin(new int[] {2,2,2,2,3,1,2}));
	}

}
