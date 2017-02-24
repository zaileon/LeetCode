public class CountRepetitions {
	
	public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
		int[] nextIdx = new int[s2.length() + 1];
		int[] repeats = new int[s2.length() + 1];
		int j = 0, cnt = 0;
		for (int k = 1; k <= n1; k++) {
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					j++;
					if (j == s2.length()) {
						j = 0;
						cnt++;
					}
				}
			}
			repeats[k] = cnt;
			nextIdx[k] = j; 
			for (int start = 0; start < k; start++) {
				if (nextIdx[start] == j) {
					int prefixCount = repeats[start];
					int patternCount = (repeats[k] - repeats[start]) * (n1 - start) / (k - start);
					int suffixCount = repeats[start + (n1 - start) % (k - start)] - repeats[start];
					return (prefixCount + patternCount + suffixCount) / n2;
				}
			}
		}
		return cnt / n2;
	}
	
	public static void main(String[] args) {
		CountRepetitions cr = new CountRepetitions();
		String s1 = "abacb", s2 = "bcaa"; int n1 = 6, n2 = 1;
//		String s1 = "nlhqgllunmelayl", s2 = "lnl"; int n1 = 2, n2 = 1;
//		String s1 = "phqghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvsrtkjpre", s2 = "pggxr"; int n1 = 100000, n2 = 100;
//		String s1 = "phqghumeay", s2 = "lnl"; int n1 = 100, n2 = 1;
//		String s1 = "acb", s2 = "ab"; int n1 = 4, n2 = 2;
		System.out.println(cr.getMaxRepetitions(s1, n1, s2, n2));
	}

}
