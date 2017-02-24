public class LongestSubstringWithAtLeastKRepeats {
	
	public int longestSubstring(String s, int k) {
		return helper(s.toCharArray(), 0, s.length(), k);
	}
	
	private int helper(char[] cs, int start, int end, int k) {
		if (start == end) return 0;
		int[] counts = new int[26];
		for (int i = start; i < end; i++) {
			counts[cs[i] - 'a']++;
		}
		boolean flag = true;
		for (int i = 0; i < 26; i++) if (counts[i] > 0 && counts[i] < k) flag = false;
		if (flag) return end - start;
		int max = 0, i = start, j = start;
		while (i < end && j < end) {
			while (i < end && counts[cs[i] - 'a'] < k) i++;
			j = i;
			while (j < end && counts[cs[j] - 'a'] >= k) j++;
			max = Math.max(max, helper(cs, i, j, k));
			i = j;
		}
		return max;
	}

	public static void main(String[] args) {
		LongestSubstringWithAtLeastKRepeats ls = new LongestSubstringWithAtLeastKRepeats();
		System.out.println(ls.longestSubstring("bbaaacbd", 3));  // 3
		System.out.println(ls.longestSubstring("aaabb", 3));  // 3
		System.out.println(ls.longestSubstring("ababbc", 2));  // 5
		System.out.println(ls.longestSubstring("ababacb", 3));  // 0
	}

}
