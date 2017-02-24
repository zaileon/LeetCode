package binary_indexed_tree;

public class NumArray {
	
	int[] bit, nums;
	int n;
	public NumArray(int[] nums) {
		this.nums = nums;
		this.n	  = nums.length;
		this.bit  = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			init(i + 1, nums[i]);
		}
	}
	
	private void init(int i, int val) {
		while (i <= n) {
			bit[i] += val;
			i += i & -i;
		}
	}
	
	public void update(int i, int val) {
		int diff = val - nums[i];
		nums[i] = val;
		init(i + 1, diff);
	}
	
	public int sumRange(int i, int j) {
		return getSum(j + 1) - getSum(i);
	}

	private int getSum(int i) {
		int sum = 0;
		while (i > 0) {
			sum += bit[i];
			i -= i & -i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,3,5};
		NumArray na = new NumArray(nums);
		System.out.println(na.sumRange(0, 2));  // 9
		na.update(1, 2);
		System.out.println(na.sumRange(0, 2));  // 8
	}

}
