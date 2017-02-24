
public class RotateArray {

	public void rotate(int[] nums, int k) {
		if (nums.length == 0) return;
		int len = nums.length;
		k = k % len;
		rotate(nums, 0, len - 1 - k);
		rotate(nums, len - k, len - 1);
		rotate(nums, 0, len - 1);
		
	}
	
	private void rotate(int[] nums, int lo, int hi) {
		while (lo < hi) {
			int temp = nums[lo];
			nums[lo] = nums[hi];
			nums[hi] = temp;
			lo++; hi--;
		}
	}
	
	public static void main(String[] args) {
		RotateArray ra = new RotateArray();
		int[] nums = {1,2,3,4,5,6,7}; int k = 3;
		ra.rotate(nums, k);
		for (int i : nums) {
			System.out.println(i);
		}
	}
}
