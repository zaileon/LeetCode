
public class SingleNumberIII {
	
	public int[] singleNumber(int[] nums) {
		int diff = 0;
		for (int num : nums) diff ^= num;
		diff &= -diff;
		int[] result = new int[2];
		for (int num : nums) {
			if ((num & diff) == 0) result[0] ^= num;
			else result[1] ^= num;
		}
		return result;
	}

	public static void main(String[] args) {
		SingleNumberIII sn = new SingleNumberIII();
		int[] nums = {1, 2, 1, 3, 2, 5};
		for (int i : sn.singleNumber(nums)) {
			System.out.println(i);
		}
	}

}
