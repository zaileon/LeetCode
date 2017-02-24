import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> wordDict) {
		if (s == null || s.length() == 0) return true;
		if (wordDict.size() == 0) return false;
		
		int maxLength = 0;
		for (String word : wordDict) {
			if (word.length() > maxLength) maxLength = word.length();
		}
		
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		
		for (int i = 1; i <= s.length(); i++) {
			for (int j = Math.max(i - maxLength, 0); j < i; j++) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		
		return dp[s.length()];
	}

	public static void main(String[] args) {
		WordBreak wb = new WordBreak();
		Set<String> wordDict = new HashSet<String>();
//		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
//		wordDict.add("a");
//		wordDict.add("aa");
//		wordDict.add("aaa");
//		wordDict.add("aaaa");
//		wordDict.add("aaaaa");
//		wordDict.add("aaaaaa");
//		wordDict.add("aaaaaaa");
//		wordDict.add("aaaaaaaa");
//		wordDict.add("aaaaaaaaa");
//		wordDict.add("aaaaaaaaaa");
		
		String s = "leetcode";
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(wb.wordBreak(s, wordDict));
	}

}
