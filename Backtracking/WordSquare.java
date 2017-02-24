import java.util.ArrayList;
import java.util.List;

public class WordSquare {

	public List<List<String>> wordSquares(String[] words) {
		List<List<String>> result = new ArrayList<>();
		if (words == null || words.length == 0 || words[0].length() == 0) return result;
		int N = words[0].length();
		TrieNode root = buildTrie(words);
		char[][] prefixs = new char[N][N];
		backtrack(result, words, prefixs, root, 0);
		return result;
	}
	
	private void backtrack(List<List<String>> result, String[] words, char[][] prefixs, TrieNode root, int start) {
		int N = words[0].length();
		if (start == N) {
			List<String> list = new ArrayList<>();
			for (int i = 0; i < N; i++) list.add(new String(prefixs[i]));
			result.add(list);
			return;
		}
		String pre = new String(prefixs[start], 0, start);
		List<String> list = findByPrefix(pre, root);
		for (String word : list) {
			prefixs[start] = word.toCharArray();
			for (int i = start + 1; i < N; i++) {
				prefixs[i][start] = word.charAt(i);
			}
			backtrack(result, words, prefixs, root, start + 1);
		}
	}
	
	public TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for (String word : words) {
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++) {
				int idx = word.charAt(i) - 'a';
				if (node.children[idx] == null) node.children[idx] = new TrieNode();
				node.startWith.add(word);
				node = node.children[idx];
			}
		}
		return root;
	}
	
	List<String> findByPrefix(String prefix, TrieNode root) {
		TrieNode node = root;
		for (int i = 0; i < prefix.length(); i++) {
			int idx = prefix.charAt(i) - 'a';
			if (node.children[idx] == null) return new ArrayList<>();
			node = node.children[idx];
		}
		return node.startWith;
	}
	
	class TrieNode {
		List<String> startWith;
		TrieNode[] children;
		public TrieNode() {
			this.startWith = new ArrayList<>();
			this.children = new TrieNode[26];
		}
	}
	
	public static void main(String[] args) {
		WordSquare ws = new WordSquare();
		String[] words = {"area","lead","wall","lady","ball"};
		for (List<String> ss : ws.wordSquares(words)) {
			for (String s : ss) {
				System.out.println(s);
			}
			System.out.println("----------------------");
		}
	}
	
}
