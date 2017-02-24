
public class SingleNumberII {
	public int singleNumber(int[] nums) {
		int ones = 0, twos = 0;
		for (int num : nums) {
			ones = (ones ^ num) & ~twos;
			twos = (twos ^ num) & ~ones;
		}
		return ones | twos;
	}
	
	// if the single number only appreas once
//	public int singleNumber(int[] nums) {
//		int result = 0;
//		for (int i = 0; i < 32; i++) {
//			int s = 0;
//			for (int num : nums) s += (num >> i) & 1;
//			result |= (s % 3) << i;
//		}
//		return result;
//	}
	
	public static void main(String[] args) {
		SingleNumberII sn = new SingleNumberII();
		int[] nums = {1,-1,1,1};
		System.out.println(sn.singleNumber(nums));
	}
}
