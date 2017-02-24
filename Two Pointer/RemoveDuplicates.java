
public class RemoveDuplicates {

	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
        int dup = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[j - 1]) 
            	dup++;
            else
            	nums[j - dup] = nums[j];
        }
        return nums.length - dup;
    }
	
	public static void main(String[] args) {
		RemoveDuplicates rd = new RemoveDuplicates();
		int[] nums = {1, 1};
//		int[] nums = {1,1,2};
		System.out.println(rd.removeDuplicates(nums));
	}

}
