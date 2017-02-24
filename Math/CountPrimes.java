import java.util.Arrays;

public class CountPrimes {

	public int countPrimes(int n) {
		boolean[] nums = new boolean[n + 1];
		Arrays.fill(nums, true);
		for (int i = 2; i * i < n; i++) {
			if (nums[i]) {
				for (int j = i * i; j < n; j += i) {
					nums[j] = false;
				}
			}
		}
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (nums[i]) count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		CountPrimes cp = new CountPrimes();
		System.out.println(cp.countPrimes(2));
	}
}
