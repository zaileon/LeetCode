import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Supplier;

public class SlidingWindowMedian {

	public double[] medianSlidingWindow(int[] nums, int k) {
		Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;
		TreeSet<Integer> left = new TreeSet<Integer>(comparator.reversed());
		TreeSet<Integer> right = new TreeSet<Integer>(comparator);
		
		Supplier<Double> median = (k % 2 == 0) ? 
				() -> ((double) nums[left.first()] + nums[right.first()]) / 2 : 
				() -> (double) nums[right.first()];
		
		Runnable rebalance = () -> { while (left.size() > right.size()) right.add(left.pollFirst()); };
				
		double[] result = new double[nums.length - k + 1];
		
		for (int i = 0; i < k; i++) left.add(i);
		rebalance.run(); result[0] = median.get();
		
		for (int i = k, r = 1; i < nums.length; i++, r++) {
			if (!left.remove(i - k)) right.remove(i - k);
			right.add(i); left.add(right.pollFirst());
			rebalance.run(); result[r] = median.get();
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		SlidingWindowMedian swm = new SlidingWindowMedian();
		int[] nums = {1,3,-1,-3,5,3,6,7}; int k = 3;
		double[] res = swm.medianSlidingWindow(nums, k);
		for (double num : res) System.out.println(num);
	}
}
