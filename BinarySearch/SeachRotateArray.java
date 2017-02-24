
public class SeachRotateArray {
	
	public int search(int[] nums, int target) {
		int lo = 0, hi = nums.length - 1;
		// this loop will converge since either lo increases or hi decrease (mid is strictly less than hi)
		// when lo == hi, lo is the rotation index, i.e. the new position of the smallest number
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] > nums[hi]) lo = mid + 1;
			else hi = mid;
		}
		int rotate = lo;
		lo = 0; hi = nums.length - 1;
		// with rotate, we can calculate the actual position of mid (rmid) in the array
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int rmid = (mid + rotate) % nums.length;
			if (nums[rmid] < target) lo = mid + 1;
			else if (nums[rmid] > target) hi = mid - 1;
			else return rmid;
		}
		return -1;
	}
	
	// combine the two searches, runs slower at LC
//	public int search(int[] nums, int target) {
//		int lo = 0, hi = nums.length - 1;
//		while (lo < hi) {
//			int mid = (lo + hi) / 2;
//			if (nums[mid] > nums[hi]) { // e.g. 3,4,5,6,1,2
//				if (target > nums[mid] || target <= nums[hi]) lo = mid + 1;
//				else hi = mid;
//			} else { // e.g. 5,6,1,2,3,4
//				if (target > nums[mid] && target <= nums[hi]) lo = mid + 1;
//				else hi = mid;
//			}
//		}
//		return nums[lo] != target ? -1 : lo;
//	}

	public static void main(String[] args) {
		SeachRotateArray sra = new SeachRotateArray();
		int[] nums = {4,5,6,7,0,1,2}; int target = 3;
		System.out.println(sra.search(nums, target));
	}

}
