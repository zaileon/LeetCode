public class LongestSubstringTwoDistinctChars {
	
//	public int lengthOfLongestSubstringTwoDistinct(String s) {
//		// 'last' points the last position of the second distinct element in the sliding window (counting from right)
//        int len = 0, start = 0, last = -1;
//        for (int i = 1; i < s.length(); i++) {
//        	// if s[i] equals to the first distinct element inside the sliding window, continue
//        	if (s.charAt(i) == s.charAt(i - 1)) continue;
//        	// otherwise we compare s[i] with the second distinct element
//        	// remember 'last' points to its last position in the window
//    		if (last >= 0 && s.charAt(i) != s.charAt(last)) {
//    			// if the second element is also different, we need to discard all its positions
//    			// this is done by set start = last + 1, and record the old window length [start, i-1]
//    			// When last < 0, there is only one element in the window, no need
//    			len = Math.max(len, i - start);
//    			start = last + 1;
//    		}
//    		// if s[i] is new or equals to the second distinct element, modify 'last' to point to the first distinct element
//    		// as now it becomes the second, and s[i] becomes the first
//    		// this position is always the last of the old window
//    		last = i - 1;
//        }
//        
//        return Math.max(len, s.length() - start);
//    }
	
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int start = 0, count = 0, len = 0;
		int[] dict = new int[256];
		for (int i = 0; i < s.length(); i++) {
			dict[s.charAt(i)]++;
			if (dict[s.charAt(i)] == 1) { // new char
				count++;
				while (count > 2) {
					dict[s.charAt(start)]--;
					if (dict[s.charAt(start)] == 0) count--;
					start++;
				}
			}
			len = Math.max(len, i - start + 1);
		}
		return len;
	}

	public static void main(String[] args) {
		LongestSubstringTwoDistinctChars lstdc = new LongestSubstringTwoDistinctChars();
		String s = "abcabc";
//		String s = "eeccebeeba";
//		String s = "eceba";
		System.out.println(lstdc.lengthOfLongestSubstringTwoDistinct(s));
	}

}
