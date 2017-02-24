
public class TotalHammingDistance {

	// for n number, count the numbers that have 1 in each position
	// for example, say the 0th bit, k numbers are 1, and n-k numbers are 0,
	// pick one from each group will contribute to the Hamming distance
	public int totalHammingDistance(int[] nums) {
		int count = 0, n = nums.length;
		for (int i = 0; i < 32; i++) {
			int bitCount = 0;
			for (int j = 0; j < n; j++) {
				bitCount += (nums[j] >> i) & 1;
			}
			count += bitCount * (n - bitCount);
		}
		return count;
	}
}
