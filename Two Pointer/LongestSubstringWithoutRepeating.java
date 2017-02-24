import java.util.Arrays;

public class LongestSubstringWithoutRepeating {
	
	public int lengthOfLongestSubstring(String s) {
		int[] cache = new int[256];
		Arrays.fill(cache, -1);
		int len = 0, start = 0; // start is the head of a substring of distinct characters, [start, i-1]
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// if we have seen c (cache[c] > 0) and c is already in the substring (cache[c] >= start)
			// we need to update len with the current length (i - start) if necessary, then change start to cache[c] + 1
			if (cache[c] >= start) {
				len = Math.max(len, i - start);
				start = cache[c] + 1;
			}
			cache[c] = i;
		}
		return Math.max(len, s.length() - start);
	}
	
	public static void main(String[] args) {
		LongestSubstringWithoutRepeating lswr = new LongestSubstringWithoutRepeating();
//		String s = "bbbbb";
		String s = "adbccba";
//		String s = "c";
//		String s = "pwwkew";
//		String s = "abcabcbb";
		System.out.println(lswr.lengthOfLongestSubstring(s));
	}
}
