
public class FindMinimumInRotatedArray {
	
	public int findMin(int[] nums) {
		int lo = 0, hi = nums.length - 1;
		while (lo <= hi) {
			if (nums[lo] < nums[hi]) return nums[lo];
			int mid = lo + ((hi - lo) >> 1);
			if (nums[mid] < nums[lo]) hi = mid;
			else lo = mid + 1;;
		}
		return nums[hi];
	}

	public static void main(String[] args) {
		FindMinimumInRotatedArray fmra = new FindMinimumInRotatedArray();
		System.out.println(fmra.findMin(new int[] {7,0,1,2,4,5,6}));
		System.out.println(fmra.findMin(new int[] {6,7,0,1,2,4,5,}));
		System.out.println(fmra.findMin(new int[] {5,6,7,0,1,2,4}));
		System.out.println(fmra.findMin(new int[] {4,5,6,7,0,1,2}));
		System.out.println(fmra.findMin(new int[] {2,4,5,6,7,0,1}));
	}

}
