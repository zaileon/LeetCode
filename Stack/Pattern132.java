public class Pattern132 {
	
	public boolean find132pattern(int[] nums) {
		int two = Integer.MIN_VALUE;
		int index = nums.length;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] < two) return true;
			while (index < nums.length && nums[i] > nums[index]) {
				two = nums[index++];
			}
			nums[--index] = nums[i];
		}
		return false;
	}

	public static void main(String[] args) {
		Pattern132 p = new Pattern132();
//		int[] nums = {3,1,4,2};
//		int[] nums = {3,1,2,2};
//		int[] nums = {3,2,4,2};
		int[] nums = {1,2,3,4};
//		int[] nums = {3,5,0,3,4};
		System.out.println(p.find132pattern(nums));
	}

}
