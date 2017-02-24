
public class WiggleSubsequence {
	public int wiggleMaxLength(int[] nums) {
		if (nums.length < 2) return nums.length;
		int idx = 1;
		while (idx < nums.length && nums[idx] == nums[0]) idx++;
		if (idx == nums.length) return 1;
		boolean increasing = nums[idx] > nums[0];
		int len = 2;
		for (int i = idx + 1; i < nums.length; i++) {
			if ((increasing && nums[i] < nums[i-1]) || (!increasing && nums[i] > nums[i-1])) {
				increasing = !increasing;
				len++;
			}
		}
		return len;
	}
	
	public static void main(String[] args) {
		WiggleSubsequence ws = new WiggleSubsequence();
//		int[] nums = {0,0};
//		int[] nums = {3,3,3,2,5};
//		int[] nums = {1,7,4,5,5};
//		int[] nums = {1,2,3,4,5,6,7,8,9};
//		int[] nums = {1,17,5,10,13,15,10,5,16,8};
		int[] nums = {1,7,4,9,2,5};
		System.out.println(ws.wiggleMaxLength(nums));
	}
}
