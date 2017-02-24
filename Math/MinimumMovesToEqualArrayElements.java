
public class MinimumMovesToEqualArrayElements {
	
	// add 1 from n - 1 elements is equivalent to subtract 1 from the other element
	// the total steps is the sum of difference of each element w.r.t. the minimal element
	public int minMoves(int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE, n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (nums[i] < min) min = nums[i];
        }
        return sum - n * min;
    }
}
