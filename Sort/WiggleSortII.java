import java.util.Random;

public class WiggleSortII {
	public void wiggleSort(int[] nums) {
		int n = nums.length;
		int median = findKthElement(nums, n / 2);
		int i = 0, k = n - 1, j = 0;
		while (j <= k) {
			int idx = (2 * j + 1) % (n | 1); 
			if (nums[idx] > median) {
				int left = (2 * i + 1) % (n | 1);
				swap(nums, left, idx);
				i++; j++;
			} else if (nums[idx] < median) {
				int right = (2 * k + 1) % (n | 1);
				swap(nums, idx, right);
				k--;
			} else {
				j++;
			}
		}
	}
	
	public int findKthElement(int[] nums, int k) {
		shuffle(nums);
		int lo = 0, hi = nums.length - 1;
		while (lo < hi) {
			int j = partition(nums, lo, hi);
			if (k < j) hi = j - 1;
			else if (k > j) lo = j + 1;
			else break;
		}
		return nums[k];
	}
	
	private void shuffle(int[] nums) {
		Random r = new Random();
		for (int i = 1; i < nums.length; i++) {
			swap(nums, i, r.nextInt(i + 1));
		}
	}
	
	private int partition(int[] nums, int lo, int hi) {
		int i = lo, j = hi + 1;
		while (true) {
			while (i < hi && nums[++i] > nums[lo]);
			while (j > lo && nums[--j] < nums[lo]);
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
		WiggleSortII ws = new WiggleSortII();
		int[] nums = {1, 3, 2, 2, 3, 1};
//		int[] nums = {4,5,5,6};
//		int[] nums = {5,3,1,2,6,7,8,5,5};
//		int[] nums = {4,5,5,5,5,6,6,6};
//		int[] nums = {1,5,1,1,6,4};
		ws.wiggleSort(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
			System.out.print(" ");
		}
	}
}
