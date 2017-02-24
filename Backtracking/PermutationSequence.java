
public class PermutationSequence {
	
	public String getPermutation(int n, int k) {
		boolean[] used = new boolean[n];
		char[] cs = new char[n];
		int total = 1;
		k--;
		for (int i = 1; i < n; i++) total *= i; 
		for (int pos = 0; pos < n; pos++) {
			int i = 0;
			for (int idx = k / total; idx >= 0; i++) {
				if (used[i]) continue;
				idx--;
			}
			i--;
			used[i] = true;
			cs[pos] = (char) ('1' + i);
			k %= total;
			if (pos != n - 1) total /= (n - pos - 1);
		}
		return new String(cs);
	}
	
	public void recursive(char[] cs, int pos, boolean[] used, int k, int total) {
		int n = cs.length, i = 0;
		for (int idx = k / total; idx >= 0; i++) {
			if (used[i]) continue;
			idx--;
		}
		i--;
		used[i] = true; 
		cs[pos] = (char)('1' + i);
		if (pos == n - 1) return;
		recursive(cs, pos + 1, used, k % total, total / (n - 1 - pos));
	}

	public static void main(String[] args) {
		PermutationSequence ps = new PermutationSequence();
		System.out.println(ps.getPermutation(3, 1));  // 123
		System.out.println(ps.getPermutation(3, 2));  // 132
		System.out.println(ps.getPermutation(3, 3));  // 213
		System.out.println(ps.getPermutation(3, 4));  // 231
		System.out.println(ps.getPermutation(3, 5));  // 312
		System.out.println(ps.getPermutation(3, 6));  // 321
	}
}
