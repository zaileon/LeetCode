
public class CountRangeSum {

	public int countRangeSum(int[] nums, int lower, int upper) {
		int n = nums.length;
		long[] sums = new long[n + 1];
		for (int i = 0; i < n; i++) sums[i + 1] = sums[i] + nums[i];
		return countWhileMergeSort(sums, 0, n + 1, lower, upper);
	}
	
	// sums left half and right half are already sorted - the most important property
	private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
		// the ranges we are checking are [0, start] and [0, end)/[0,end-1]
		// if end == start + 1, the two are the same
		if (end - start <= 1) return 0; 
		int mid = (start + end) / 2;
		int count = countWhileMergeSort(sums, start, mid, lower, upper) +
				countWhileMergeSort(sums, mid, end, lower, upper);
		int j = mid, k = mid, t = mid;
		long[] cache = new long[end - start];
		for (int i = start, r = 0; i < mid; ++i, ++r) {
			// when i increase, sums[i] increase, j/k also will move rightward, the double loop is actually linear
			// because j/k/t only go from mid to end at most once
			// also j >= k because upper > lower, the count that satisfies the condition is within [k, j)
			// so if j == k, count increase by 0
			while (k < end && sums[k] - sums[i] < lower) k++; // find the first k to make sums[k] - sums[i] >= lower
			while (j < end && sums[j] - sums[i] <= upper) j++;// find the first j to make sums[j] - sums[i] <= upper
			count += j - k;
			
			// Regular merge sort, copy anything that is smaller than sums[i] to cache
			while (t < end && sums[t] < sums[i]) cache[r++] = sums[t++];
			cache[r] = sums[i];
		}
		// we are inserting sums from the right half that are smaller than individual left element
		// the rest of right half doesn't be changed
		System.arraycopy(cache, 0, sums, start, t - start);
		return count;
	}
	
	public static void main(String[] args) {
		CountRangeSum crs = new CountRangeSum();
		int[] nums = {-2,5,-1}; int lower = -2, upper = 2;
		System.out.println(crs.countRangeSum(nums, lower, upper));
	}
}
