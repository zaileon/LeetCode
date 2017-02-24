
public class FindDuplicate {

	// Binary search
//	public int findDuplicate(int[] nums) {
//		int N = nums.length;
//		int l = 1, r = N - 1;
//		while (l < r) {
//			int cnt = 0, mid = l + (r - l) / 2;
//			for (int i = 0; i < N; i++) {
//				if (nums[i] <= mid) cnt++;
//			}
//			if (cnt > mid) r = mid;
//			else l = mid + 1;
//		}
//		return l;
//	}
	
	// Two pointer
	public int findDuplicate(int[] nums) {
		if (nums.length <= 1) return -1;
		int slow = nums[0], fast = nums[nums[0]];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		fast = 0;
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}
	
	public static void main(String[] args) {
		FindDuplicate fd = new FindDuplicate();
		int[] nums = {4,6,1,2,7,8,2,3,5};
		System.out.println(fd.findDuplicate(nums));
	}
}
