import java.util.HashSet;
import java.util.Set;

public class MaximumXOR {

	// mask will be 1000, 1100, 1110, 1111
	// for each mask, put the prefixs into a set
	// then from the set, if we can further find 2 numbers that xor to set the ith bit, we set max |= 1<<i
	public int findMaximumXOR(int[] nums) {
		int max = 0, mask = 0;
		Set<Integer> set = new HashSet<>();
		for (int i = 31; i >= 0; i--) {
			mask |= 1 << i;
			for (int num : nums) {
				set.add(num & mask);
			}
			int tmp = max | 1 << i;
			for (int prefix : set) {
				if (set.contains(tmp ^ prefix)) { // if a ^ b = c, then b ^ c = a
					max = tmp; // we found a pair that xor to set the ith bit, break
					break;
				}
			}
			set.clear();
		}
		return max;
	}
	
	public static void main(String[] args) {
		MaximumXOR mxor = new MaximumXOR();
		int[] nums = {3,10,5,25,2,8};
		System.out.println(mxor.findMaximumXOR(nums));
	}
}
