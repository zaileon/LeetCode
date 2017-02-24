
public class PalindromePartitionII {
	public int minCut(String s) {
		char[] c = s.toCharArray();
		int n = s.length();
		int[] cut = new int[n];
		boolean[][] isPal = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = 0; j <= i; j++) {
				// [j, i] is a palindrome if and only if [j+1, i-1] is also a palindrome and c[i]==c[j]
				// j == i, isPal[j][i] = true, one character
				// j == i - 1, isPal[j][i] = true <=> c[i] == c[j] && (true || ...)   -- even
				// j == i - 2, isPal[j][i] = true <=> c[i] == c[j] && (false || isPal[i-1][i-1]/true)  -- odd
				if (c[i] == c[j] && (j + 1 > i - 1 || isPal[j + 1][i - 1])) {
					isPal[j][i] = true;
					min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
				}
			}
			cut[i] = min;
		}
		return cut[n - 1];
	}
	
	public static void main(String[] args) {
		PalindromePartitionII pp = new PalindromePartitionII();
		String s = "abbab";
		System.out.println(pp.minCut(s));
	}
}
