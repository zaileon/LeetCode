public class SortTransformedArray {
	
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		int[] ret = new int[nums.length];
		boolean reverse = false;
		if (a == 0) {
			if (b < 0) reverse = true;
			for (int i = 0; i < nums.length; i++) ret[i] = b * nums[i] + c;
		} else {
			reverse = a > 0;
			double mid = - b / (2.0 * a);
			for (int i = 0, j = nums.length - 1, k = 0; i <= j; k++) {
				if (Math.abs(nums[i] - mid) > Math.abs(nums[j] - mid)) {
					ret[k] = a * nums[i] * nums[i] + b * nums[i] + c;
					i++;
				} else {
					ret[k] = a * nums[j] * nums[j] + b * nums[j] + c;
					j--;
				}
			}
			
		}
		if (reverse) {
			for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
				int temp = ret[i];
				ret[i] = ret[j];
				ret[j] = temp;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		SortTransformedArray sta = new SortTransformedArray();
		int[] nums = {-4,-2,2,4}; int a = 0, b = 3, c = 5;
		for (int i : sta.sortTransformedArray(nums, a, b, c)) {
			System.out.println(i);
		}
	}

}
