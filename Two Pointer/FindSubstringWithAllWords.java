import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubstringWithAllWords {
	
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
		if (s == null || words == null || words.length == 0) return result;
		int n = s.length(), k = words.length, wl = words[0].length();
		if (n < k * wl) return result;
		
		Map<String, Integer> counts = new HashMap<>();
		for (String word : words) counts.put(word, counts.getOrDefault(word, 0) + 1);
		
		for (int i = 0; i < wl; i++) {
			Map<String, Integer> cnt = new HashMap<>();
			int total = 0;
			for (int start = i, j = i; j <= n - wl; j += wl) {
				String w = s.substring(j, j + wl);
				// if w is in dict
				if (counts.containsKey(w)) {
					cnt.put(w, cnt.getOrDefault(w, 0) + 1);
					if (cnt.get(w) <= counts.get(w)) {
						total++;
					} else {  // one extra w, remove word from start, the head might not be w
						while (cnt.get(w) > counts.get(w)) {
							String head = s.substring(start, start + wl);
							cnt.put(head, cnt.get(head) - 1);
							if (cnt.get(head) < counts.get(head)) total--; // if head is not w, total--; otherwise total doesn't change
							start += wl;
						}
					}
					if (total == k) {
						result.add(start);
						total--;
						String head = s.substring(start, start + wl);
						cnt.put(head, cnt.get(head) - 1);
						start += wl;
					}
				} else {   // else restart counting
					cnt.clear();
					total = 0;
					start = j + wl;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		FindSubstringWithAllWords fsaw = new FindSubstringWithAllWords();
		String s = "baaabc"; String[] words = {"a", "b", "a"};
//		String s = "barfoothefoobarman"; String[] words = {"foo", "bar"};
		for (int i : fsaw.findSubstring(s, words)) {
			System.out.println(i);
		}
	}

}
