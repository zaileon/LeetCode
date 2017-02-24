
public class SearchRotateArrayII {
	
	// combine the two searches, runs slower at LC
	public boolean search(int[] nums, int target) {
		int lo = 0, hi = nums.length - 1;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (nums[mid] == target) return true;
			if (nums[mid] > nums[hi]) { // e.g. 3,4,5,6,1,2
				if (target < nums[mid] && target >= nums[lo]) hi = mid;
				else lo = mid + 1;
			} else if (nums[mid] < nums[hi]) { // e.g. 5,6,1,2,3,4
				if (target > nums[mid] && target <= nums[hi]) lo = mid + 1;
				else hi = mid;
			} else {
				hi--;
			}
		}
		return nums[lo] != target ? false : true;
	}

	public static void main(String[] args) {
		SearchRotateArrayII sra = new SearchRotateArrayII();
		int[] nums = {3,1}; int target = 1;
//		int[] nums = {1,1,3,1}; int target = 3;
		System.out.println(sra.search(nums, target));
	}

}
