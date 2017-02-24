import java.util.Random;

public class MinimumMovesToEqualArrayElementsII {

	public int minMoves2(int[] nums) {
		if (nums.length <= 1) return 0;
		int median = findKthElement(nums, nums.length / 2);
		int sum = 0;
		for (int num : nums) sum += Math.abs(num - median);
		return sum;
	}
	
	private int findKthElement(int[] nums, int k) {
		shuffle(nums);
		int lo = 0, hi = nums.length - 1;
		while (lo < hi) {
			int pos = partition(nums, lo, hi);
			if (pos < k) lo = pos + 1;
			else if (pos > k) hi = pos - 1;
			else break;
		}
		return nums[k];
	}
	
	private void shuffle(int[] nums) {
		final Random random = new Random();
		for (int i = 1; i < nums.length; i++) {
			int r = random.nextInt(i + 1);
			swap(nums, i, r);
		}
	}
	
	private int partition(int[] nums, int lo, int hi) {
		int pivot = nums[lo];
		int i = lo, j = hi + 1;
		while (true) {
			while (++i <= hi && nums[i] < pivot);
			while (--j >= lo && nums[j] > pivot);
			if (i >= j) break;
			swap(nums, i, j);
		}
		swap(nums, lo, j);
		return j;
	}
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[j];
		nums[j] = nums[i];
		nums[i] = tmp;
	}
	
	public static void main(String[] args) {
		MinimumMovesToEqualArrayElementsII mm = new MinimumMovesToEqualArrayElementsII();
		int[] nums = {1,2,5,8,0};
//		int[] nums = {1,3,2};
//		int[] nums = {1,2,3,4};
//		int[] nums = {1,3,2,4};
		System.out.println(mm.minMoves2(nums));
	}
}
