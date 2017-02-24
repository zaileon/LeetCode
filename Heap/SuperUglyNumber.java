import java.util.Arrays;

public class SuperUglyNumber {
	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] ugly = new int[n];
		int[] idx = new int[primes.length];
		int[] val = new int[primes.length];
		Arrays.fill(val, 1);
		
		int next = 1;
		for (int i = 0; i < n; i++) {
			ugly[i] = next;
			next = Integer.MAX_VALUE;
			for (int j = 0; j < primes.length; j++) {
				if (val[j] == ugly[i]) val[j] = ugly[idx[j]++] * primes[j];
				next = Math.min(next, val[j]);
			}
		}
		return ugly[n-1];
	}
	
	public static void main(String[] args) {
		SuperUglyNumber suu = new SuperUglyNumber();
		int n = 12; int[] primes = {2,7,13,19};
		System.out.println(suu.nthSuperUglyNumber(n, primes));
	}
}
