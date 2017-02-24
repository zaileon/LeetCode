
public class LongestSubstringKDistinctChars {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int start = 0, count = 0, len = 0;
		int[] dict = new int[256];
		for (int i = 0; i < s.length(); i++) {
			dict[s.charAt(i)]++;
			if (dict[s.charAt(i)] == 1) { // new char
				count++;
				while (count > k) {
					dict[s.charAt(start)]--;
					if (dict[s.charAt(start)] == 0) count--;
					start++;
				}
			}
			len = Math.max(len, i - start + 1);
		}
		return len;
	}
}
