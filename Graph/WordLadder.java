import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {

	// Two end BFS, use visited to mark all visited strings
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>(), visited = new HashSet<>();
		beginSet.add(beginWord); visited.add(beginWord);
		endSet.add(endWord); visited.add(endWord);
		
		Set<String> wordSet = new HashSet<>(wordList);
		if (!wordSet.contains(endWord)) return 0;
		
		int dist = 1;
		
		while (!beginSet.isEmpty() && !endSet.isEmpty()) {
			// always start from the smaller set
			if (beginSet.size() > endSet.size()) {
				Set<String> set = beginSet;
				beginSet = endSet;
				endSet = set;
			}
			Set<String> next = new HashSet<String>();
			dist++;
			
			for (String word : beginSet) {
				StringBuilder sb = new StringBuilder(word);
				for (int j = 0; j < beginWord.length(); j++) {
					char old = word.charAt(j);
					for (char c = 'a'; c <= 'z'; c++) {
						sb.setCharAt(j, c);
						String target = sb.toString();
						// there is a direct link between a word from beginSet and a word from endSet
						if (endSet.contains(target)) return dist;
						// otherwise update frontier, and mark it as visited
						if (!visited.contains(target) && wordSet.contains(target)) {
							next.add(target);
							visited.add(target);
						}
					}
					sb.setCharAt(j, old);
				}
			}
			beginSet = next;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		WordLadder wl = new WordLadder();
		String beginWord = "hit", endWord = "cog";
		List<String> wordList = new ArrayList<String>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
		System.out.println(wl.ladderLength(beginWord, endWord, wordList));
	}
}
