
public class ShortestPalindrome {
	
	// given a string "abac", construct "abac#caba"
	// compute the next table using KMP algorithm [0,0,1,0,0,0,1,2,3]
	// 3 is the maximum length of palindrome "abac" starting from 0
	// then we only need to prepend the reverse substring from 3 to the end
	public String shortestPalindrome(String s) {
		String str = s + "#" + new StringBuilder(s).reverse().toString();
		int[] next = new int[str.length()];
		for (int i = 1, j = 0; i < str.length();) {
			if (str.charAt(i) == s.charAt(j)) next[i++] = ++j;
			else if (j != 0) j = next[j - 1];
			else next[i++] = 0;
		}
		return new StringBuilder(s.substring(next[next.length - 1])).reverse().toString() + s;
	}
	
	public static void main(String[] args) {
		ShortestPalindrome sp = new ShortestPalindrome();
		System.out.println(sp.shortestPalindrome("abac"));
	}
}
