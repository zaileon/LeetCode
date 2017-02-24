import java.util.TreeSet;

public class Kadane {

	public int kadane(int[] nums) {
		int sum = 0, result = Integer.MIN_VALUE;
		for (int num : nums) {
			sum = sum > 0 ? sum + num : num;
			result = Math.max(result, sum);
		}
		return result;
	}
	
	public int kadaneWithCap(int[] nums, int k) {
		TreeSet<Integer> set = new TreeSet<>();
		set.add(0);
		int sum = 0, result = Integer.MIN_VALUE;
		for (int num : nums) {
			sum += num;
			Integer i = set.ceiling(sum - k);
			if (i != null) result = Math.max(result, sum - i);
			set.add(sum);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Kadane kadane = new Kadane();
		int[] nums = {2}; int k = 2;
//		int[] nums = {1,-2,2,1,-1}; int k = 1;
		System.out.println(kadane.kadaneWithCap(nums, k));
	}

}
