
public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
	            nums[j++] = nums[i];
            }
        }
        for (; j < nums.length; j++) nums[j] = 0;
    }
	
	public static void main(String[] args) {
		MoveZeroes mz = new MoveZeroes();
//		int[] nums = {2,1};
//		int[] nums = {0};
//		int[] nums = {1};
		int[] nums = {0,1,0,3,12};
		mz.moveZeroes(nums);
		for (int i : nums) {
			System.out.println(i);
		}
	}
}
