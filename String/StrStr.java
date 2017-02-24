
public class StrStr {
	
	
	// KMP algorithm
	public int strStr(String haystack, String needle) {
		int m = needle.length(), n = haystack.length();
		if (m == 0) return 0;
		int[] lps = preprocessing(needle);
		
		for (int i = 0, j = 0; i < n; ) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				i++; j++;
				if (j == m) return i - j;
			} 
			if (i < n && haystack.charAt(i) != needle.charAt(j)){
				if (j != 0) j = lps[j - 1];
				else i++;
			}
		}
		return -1;
	}
	
	// Longest Proper Prefix which is also suffix. "Proper" excludes the whole string
	private int[] preprocessing(String needle) {
		int m = needle.length();
		int[] lps = new int[m];
		for (int i = 1, j = 0; i < m; ) {
			if (needle.charAt(i) == needle.charAt(j))
				lps[i++] = ++j;
			else if (j != 0) j = lps[j - 1];
			else i++;
		}
		return lps;
	}
	
	public static void main(String[] args) {
		StrStr ss = new StrStr();
		String text = "abcxabcdabxabcdabcdabcy", pattern = "abcdabcy"; //15
//		String text = "a", pattern = "a";
//		String text = "", pattern = "a";
		System.out.println(ss.strStr(text, pattern));
	}

}
