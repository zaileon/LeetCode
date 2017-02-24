import java.util.Random;

public class KthLargest {
	public int findKthLargest(int[] nums, int k) {
		shuffle(nums);
		k = nums.length - k;
		int lo = 0, hi = nums.length - 1;
		while (lo < hi) {
			int j = partition(nums, lo, hi);
			if (j < k) lo = j + 1;
			else if (j > k) hi = j - 1;
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
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		KthLargest kl = new KthLargest();
		int[] nums = {3,5,2,6,1,4};
//		System.out.println(kl.findKthLargest(nums, 2)); // 5
//		System.out.println(kl.findKthLargest(nums, 1));  // 6
//		System.out.println(kl.findKthLargest(nums, 4));  // 3
//		System.out.println(kl.findKthLargest(new int[] {-1,2,0}, 2)); // 0
//		System.out.println(kl.findKthLargest(new int[] {-1,2,0}, 3)); // -1
		System.out.println(kl.findKthLargest(new int[] {7,6,5,4,3,2,1}, 2)); // 6
	}
}
