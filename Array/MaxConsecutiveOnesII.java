
public class MaxConsecutiveOnesII {
	
	public int findMaxConsecutiveOnes(int[] nums) {
		int len = 0;
		int hp = 2; // use a 2-num window
		int i = 0, j = 0, k = 0;
		for (; i < nums.length; i++) {
			if (nums[i] == 0) {
				hp--; 
				if (hp == 0) { // window totally broken, check the length
					len = Math.max(len, i - j);
					j = k + 1; // set j to the next 1
					hp = 1; // restore the window to partial broken state
				}
				k = i; // k keeps track of the position of latest zero
			}
		}
		len = Math.max(len, i - j);
		return len;
	}

	public static void main(String[] args) {
		MaxConsecutiveOnesII mco = new MaxConsecutiveOnesII();
//		int[] nums = {1,0,1,0,1,0};
		int[] nums = {1,0,1,1,0};
		System.out.println(mco.findMaxConsecutiveOnes(nums));
	}

}
