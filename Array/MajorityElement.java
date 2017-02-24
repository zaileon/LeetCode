
public class MajorityElement {
	public int majorityElement(int[] nums) {
        int count = 1, major = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (count == 0) {
				major = nums[i];
				count = 1;
			} else if (nums[i] == major) {
				count++;
			} else {
				count--;
			}
		}
		return major;
    }

	public static void main(String[] args) {
		MajorityElement me = new MajorityElement();
		int[] nums = {1,2,3,2,1,2,2,4,2};
		System.out.println(me.majorityElement(nums));
	}

}
