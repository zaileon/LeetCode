import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPatternII {

	public boolean wordPatternMatch(String pattern, String str) {
		Map<Character, String> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		return backtrack(pattern, str, map, set, 0, 0);
	}
	
	private boolean backtrack(String pattern, String str, Map<Character, String> map, Set<String> set, int i, int j) {
		if (i == pattern.length() && j == str.length()) return true;
		if (i == pattern.length() || j == str.length()) return false;
		char c = pattern.charAt(i);
		if (!map.containsKey(c)) {
			for (int k = j + 1; k <= str.length(); k++) {
				String s = str.substring(j, k);
				if (!set.add(s)) continue;
				map.put(c, s);
				if (backtrack(pattern, str, map, set, i + 1, k)) return true;
				set.remove(s);
			}
			map.remove(c);
			return false;
		} else {
			String t = map.get(c);
			if (!str.startsWith(t, j)) return false;
			return backtrack(pattern, str, map, set, i + 1, j + t.length());
		}
	}
	
	public static void main(String[] args) {
		WordPatternII wp = new WordPatternII();
//		String pattern = "abba", str = "dogdogdogdog"; // false
//		String pattern = "aabb", str = "xyzabcxzyabc"; // false
//		String pattern = "aaaa", str = "asdasdasdasd"; // true
		String pattern = "abab", str = "redblueredblue"; // true
		System.out.println(wp.wordPatternMatch(pattern, str));
	}
}
