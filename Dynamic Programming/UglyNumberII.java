
public class UglyNumberII {
	public int nthUglyNumber(int n) {
		if (n <= 0) return 0;
		int[] k = new int[n];
		int t2 = 0, t3 = 0, t5 = 0;
		k[0] = 1;
		for (int i = 1; i < n; i++) {
			k[i] = Math.min(k[t2] * 2, Math.min(k[t3] * 3, k[t5] * 5));
			if (k[i] == k[t2] * 2) t2++;
			if (k[i] == k[t3] * 3) t3++;
			if (k[i] == k[t5] * 5) t5++;
		}
		return k[n-1];
	}
	
	public static void main(String[] args) {
		UglyNumberII un = new UglyNumberII();
		int n = 1;
		System.out.println(un.nthUglyNumber(n));
	}
}
