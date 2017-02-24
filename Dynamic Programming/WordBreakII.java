import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {
	// Topdown solution of DP, using memoization
	public List<String> wordBreak(String s, Set<String> wordDict) {
		return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
	}
	
	private List<String> DFS(String s, Set<String> wordDict, Map<String, LinkedList<String>> map) {
		if (map.containsKey(s)) return map.get(s);
		LinkedList<String> result = new LinkedList<String>();
		if (s.length() == 0) {
			result.add("");
			return result;
		}
		for (String word : wordDict) {
			if (s.startsWith(word)) {
				List<String> sublist = DFS(s.substring(word.length()), wordDict, map);
				for (String sub : sublist) {
					result.add(word + (sub.isEmpty() ? "" : " ") + sub);
				}
			}
		}
		map.put(s, result);
		return result;
	}

	public static void main(String[] args) {
		WordBreakII wb = new WordBreakII();
		Set<String> wordDict = new HashSet<>();
//		String s = "catsanddog";
//		wordDict.add("cat");
//		wordDict.add("cats");
//		wordDict.add("and");
//		wordDict.add("sand");
//		wordDict.add("dog");
		
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		wordDict.add("a");
		wordDict.add("aa");
		wordDict.add("aaa");
		wordDict.add("aaaa");
		wordDict.add("aaaaa");
		wordDict.add("aaaaaa");
		wordDict.add("aaaaaaa");
		wordDict.add("aaaaaaaa");
		wordDict.add("aaaaaaaaa");
		wordDict.add("aaaaaaaaaa");
		
		for (String sentence : wb.wordBreak(s, wordDict)) {
			System.out.println(sentence);
		}
	}

}
