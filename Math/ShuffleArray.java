import java.util.Random;

public class ShuffleArray {

	private Random random;
	private int[] nums;
	
	public ShuffleArray(int[] nums) {
		this.random = new Random();
		this.nums = nums;
	}
	
	public int[] reset() {
		return nums;
	}
	
	public int[] shuffle() {
		if (nums == null) return null;
		int[] clone = nums.clone();
		for (int i = 0; i < nums.length; i++) {
			int j = random.nextInt(i + 1); // [0,i+1), equal possibility for 0,...,i
			swap(clone, i, j);
		}
		return clone;
	}
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	public static void main(String[] args) {
		ShuffleArray sa = new ShuffleArray(new int[] {1,2,3});
		System.out.println(sa.shuffle());
		System.out.println(sa.reset());
		System.out.println(sa.shuffle());
	}
}
