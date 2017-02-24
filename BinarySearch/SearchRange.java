public class SearchRange {

	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[] {-1,-1};
		if (nums == null || nums.length == 0) return result;
		int l = 0, r = nums.length - 1;
		while (l < r) {
			int mid = (l + r) / 2;
			if (nums[mid] < target) l = mid + 1;
			else r = mid;
		}
		if (nums[l] != target) return result;
		result[0] = l;
		
		l = 0; r = nums.length - 1;
		while (l < r) {
			int mid = (l + r + 1) / 2;
			if (nums[mid] > target) r = mid - 1;
			else l = mid;
		}
		result[1] = l;
		return result;
	}
	
	public static void main(String[] args) {
		SearchRange sr = new SearchRange();
		int[] nums = {}; int target = 0;
//		int[] nums = {5,7,7,8,8,10}; int target = 7;
//		int[] nums = {1,1,1,1,1,1,2,3,4,4,5,5,5,6,7,8,8,8,8}; int target = 0;
		for (int i : sr.searchRange(nums, target)) {
			System.out.println(i);
		}
	}
}
