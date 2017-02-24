
public class WiggleSort {
	// swap A[i] with A[i-1] iff
	// i is odd (peak) but A[i-1]>A[i] or
	// i is even(bottom) but A[i-1]<A[i]
	public void wiggleSort(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			int previous = nums[i - 1];
			if (((i & 1) == 1) == (previous > nums[i])) {
				nums[i - 1] = nums[i];
				nums[i] = previous;
			}
		}
	}
}
