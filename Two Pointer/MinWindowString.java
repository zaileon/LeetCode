
public class MinWindowString {
	public String minWindow(String s, String t) {
		int[] cnt = new int[128];
		for (char c : t.toCharArray()) cnt[c]++;
		// head saves the start position of minimal string, remain counts the number of character left in t
		int head = 0, start = 0, end = 0, min = Integer.MAX_VALUE, len = s.length(), remain = t.length();
		while (end < len) {
			// If char in s exists in t, decrease counter
			if (cnt[s.charAt(end)] > 0) remain--;
			// Decrease m[s[end]]. If char does not exist in t, m[s[end]] will be negative
			cnt[s.charAt(end)]--;
			end++;
			// When we found a valid window, move start to find smaller window
			while (remain == 0) {
				if (end - start < min && cnt[s.charAt(start)] >= 0) {
					head = start;
					min = end - start;
				}
				cnt[s.charAt(start)]++;
				// Only chars in t will make map positive. We are skipping one of those
				if (cnt[s.charAt(start)] > 0) remain++;
				start++;
			}
		}
		return min == Integer.MAX_VALUE ? "" : s.substring(head, head + min);
	}
	
	public static void main(String[] args) {
		MinWindowString mws = new MinWindowString();
		System.out.println(mws.minWindow("ADOBECODEBANC", "ABC"));
	}
}
