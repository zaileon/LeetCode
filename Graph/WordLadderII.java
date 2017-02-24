import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WordLadderII {
	
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> result = new ArrayList<>();
		if (wordList == null || wordList.size() == 0) return result;
		Map<String, List<String>> adj = buildAdjacencyList(beginWord, endWord, wordList);
		backtrace(endWord, beginWord, adj, new LinkedList<String>(), result);
		return result;
	}
	
	private Map<String, List<String>> buildAdjacencyList(String begin, String end, List<String> wordList) {
		Map<String, List<String>> adj = new HashMap<String, List<String>>();
		
		Map<String, Integer> ladder = new HashMap<>(wordList.size());
		for (String word : wordList) ladder.put(word, Integer.MAX_VALUE);
		ladder.put(begin, 0);
		
		Queue<String> queue = new ArrayDeque<>();
		queue.offer(begin);
		
		int min = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			String word = queue.poll();
			int step = ladder.get(word) + 1; // number of steps to reach one word
			if (step > min) break;
			for (int j = 0; j < word.length(); j++) {
				char[] cs = word.toCharArray();
				for (char ch = 'a'; ch <= 'z'; ch++) {
					cs[j] = ch;
					String w = new String(cs);
					if (ladder.containsKey(w)) {
						if (step > ladder.get(w)) continue; // check if it's the shortest path
						else if (step < ladder.get(w)) {
							queue.add(w);
							ladder.put(w, step);
						} else; // if one word is already in the ladder, don't insert the same word again
						// for example, say beginWord: got(0), both hot(1) and git(1) can reach hit(2)
						adj.putIfAbsent(w, new LinkedList<String>());
						adj.get(w).add(word);
						if (w.equals(end)) min = step;
					}
				}
			}
		}
		return adj;
	}
	
	private void backtrace(String word, String begin, Map<String, List<String>> adj, LinkedList<String> path, List<List<String>> result) {
		if (word.equals(begin)) {
			path.addFirst(begin);
			result.add(new ArrayList<String>(path));
			path.removeFirst();
			return;
		}
		path.addFirst(word);
		if (adj.get(word) != null) {
			for (String neighbor : adj.get(word)) {
				backtrace(neighbor, begin, adj, path, result);
			}
		}
		path.removeFirst();
	}
	

	public static void main(String[] args) {
		WordLadderII wl = new WordLadderII();
		String beginWord = "hit", endWord = "cog";
		List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
		for (List<String> path : wl.findLadders(beginWord, endWord, wordList)) {
			for (String p : path) {
				System.out.print(p + " ");
			}
			System.out.println();
		}
	}

}
