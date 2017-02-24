
public class NextPermutation {
	
	// http://en.wikipedia.org/wiki/Permutation
	// reverse find the first element k that breaks descension
	// if k == -1 it means the entire nums is in descending order, just reverse it
	// else reverse find the first element l that is greater than nums[k], and swap nums[k] and nums[l]
	// finally reverse the part of nums [k+1, N-1]
	public void nextPermutation(int[] nums) {
		int N = nums.length;
		if (N < 2) return;
		int k = N - 2;
		while (k >= 0) {
			if (nums[k] >= nums[k + 1]) k--; else break;
		}
		if (k == -1) { reverse(nums, 0, N - 1); return; }
		int l = N - 1;
		while (nums[l] <= nums[k]) l--;
		swap(nums, k, l);
		reverse(nums, k + 1, N - 1);
	}

	private void reverse(int[] nums, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			swap(nums, i, j);
		}
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		NextPermutation np = new NextPermutation();
		int[] nums = {1,2,3};
		for (int i = 0; i <= 6; i++) {
			np.nextPermutation(nums);
			for (int num : nums) System.out.print(num);
			System.out.println("");
		}
	}

}
