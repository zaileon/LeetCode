
public class WordDictionary {
	TrieNode root;
	
	public WordDictionary() {
		root = new TrieNode();
	}
	
	public void addWord(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (node.children[c - 'a'] == null) 
				node.children[c - 'a'] = new TrieNode();
			node = node.children[c - 'a'];
		}
		node.isWord = true;
	}
	
	public boolean search(String word) {
		return searchHelper(root, word.toCharArray(), 0);
	}
	
	private boolean searchHelper(TrieNode node, char[] cs, int pos) {
		if (pos == cs.length) return node.isWord;
		char c = cs[pos];
		if (c == '.') {
			for (int i = 0; i < 26; i++) {
				if (node.children[i] != null && searchHelper(node.children[i], cs, pos + 1))
					return true;
			}
			return false;
		} else {
			if (node.children[c - 'a'] == null) return false;
			return searchHelper(node.children[c - 'a'], cs, pos + 1);
		}
	}
	
	class TrieNode {
		TrieNode[] children = new TrieNode[26];
		boolean isWord = false;
	}

	public static void main(String[] args) {
		WordDictionary wd = new WordDictionary();
		wd.addWord("bad");
		wd.addWord("dad");
		wd.addWord("mad");
		System.out.println(wd.search("pad"));  // false
		System.out.println(wd.search("bad"));  // true
		System.out.println(wd.search(".ad"));  // true
		System.out.println(wd.search("b.."));  // true
	}

}
