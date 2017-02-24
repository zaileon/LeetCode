public class Trie {
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public void insert(String word) {
		TrieNode n = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (n.children[c - 'a'] == null) {
				n.children[c - 'a'] = new TrieNode();
			}
			n = n.children[c - 'a'];
		}
		n.isWord = true;
	}
	
	public boolean search(String word) {
		TrieNode n = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (n.children[c - 'a'] == null) return false;
			n = n.children[c - 'a'];
		}
		return n.isWord;
	}

	public boolean startWith(String prefix) {
		TrieNode n = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (n.children[c - 'a'] == null) return false;
			n = n.children[c - 'a'];
		}
		return true;
	}
	
	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("aaab");
		System.out.println(t.search("aaab"));
		System.out.println(t.startWith("aa"));
	}
	
	class TrieNode {
		private TrieNode[] children = new TrieNode[26];
		private boolean isWord;
		public TrieNode() {}
	}
}

