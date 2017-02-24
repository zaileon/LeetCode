import java.util.Arrays;

public class MaximumGap {

	// bucket sort
	// the largest gap can not be smaller than (max-min)/(N-1)
	// by putting the numbers into buckets of each gap length, we can guarantee the maxGap
	// only exist across boundaries, with min and max as the two ends. bucket[i] = [(i-1)*gap, i*gap)
	// There is at least one empty bucket. Gap can be reduced further, resulting more empty buckets, but it won't affect the result
	// the current gap is the maximum gap feasible
	public int maxGap(int[] nums) {
		if (nums == null || nums.length < 2) return 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int num : nums) {
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		if (min == max) return 0;
		
		int gap = (max - min - 1) / (nums.length - 1) + 1;
//		int gap = (int) Math.ceil(((double) max - min) / (nums.length - 1));
		int   bucketNum = (max - min - 1) / gap + 1;
		int[] bucketMin = new int[bucketNum];
		int[] bucketMax = new int[bucketNum];
		Arrays.fill(bucketMin, Integer.MAX_VALUE);
		
		for (int num : nums) {
			if (num == min || num == max) 
				continue;
			int idx = (num - min) / gap;
			if (num > bucketMax[idx]) bucketMax[idx] = num;
			if (num < bucketMin[idx]) bucketMin[idx] = num;
		}
		
		int maxGap = 0;
		int previous = min;
		for (int i = 0; i < bucketNum; i++) {
			if (bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == 0) 
				continue;
			maxGap = Math.max(maxGap, bucketMin[i] - previous);
			previous = bucketMax[i];
		}
		maxGap = Math.max(maxGap, max - previous);
		
		return maxGap;
	}
	
	public static void main(String[] args) {
		MaximumGap mg = new MaximumGap();
		int[] nums = {1,3,4};
		System.out.println(mg.maxGap(nums));
	}
}
