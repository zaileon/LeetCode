
public class EncodeStringWithShortestLength {
	
	public String encode(String s) {
		if (s.length() < 5) return s;
		int N = s.length();
		String[][] dp = new String[N][N];
		for (int len = 1; len <= N; len++) {
			for (int l = 0; l < N - len + 1; l++) {
				int r = l + len - 1;
				dp[l][r] = s.substring(l, r + 1);
				if (len > 4) {
					for (int k = l; k < r; k++) {
						if (dp[l][k].length() + dp[k+1][r].length() < dp[l][r].length()) 
							dp[l][r] = dp[l][k] + dp[k+1][r];
					}
					String replace = shrink(s, l, r, dp);
					if (replace.length() <= dp[l][r].length()) dp[l][r] = replace;
				}
			}
		}
		return dp[0][N - 1];
	}
	
	private String shrink(String s, int l, int r, String[][] dp) {
		String tmp = s.substring(l, r + 1);
		int pos = (tmp + tmp).substring(1).indexOf(tmp) + 1;
		if (pos >= tmp.length()) return tmp;
		return (tmp.length() / pos) + "[" + dp[l][l+pos-1] + "]"; 
	}
	
	public static void main(String[] args) {
		EncodeStringWithShortestLength essl = new EncodeStringWithShortestLength();
//		System.out.println(essl.encode("aaaaa"));
//		System.out.println(essl.encode("aaaaaaaaaa"));
//		System.out.println(essl.encode("aabcaabcd"));
		System.out.println(essl.encode("abbbabbbcabbbabbbc"));
	}
}
