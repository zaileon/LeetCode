
public class MaxConsecutiveOnes {

	public int findMaxConsecutiveOnes(int[] nums) {
		int len = 0, i = 0, j = 0;
		while (i < nums.length) {
			if (nums[i] == 0) {
				len = Math.max(len, i - j);
				j = i + 1;
			}
			i++;
		}
		len = Math.max(len, i - j);
		return len;
	}
	
	public static void main(String[] args) {
		MaxConsecutiveOnes mco = new MaxConsecutiveOnes();
		int[] nums = {0,1,1,0,1,1,1};
//		int[] nums = {1,1,0,1,1,1};
		System.out.println(mco.findMaxConsecutiveOnes(nums));
	}
}
