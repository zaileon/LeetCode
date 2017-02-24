import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromPairs {
	
	// Hashtable solution
//	public List<List<Integer>> palindromePairs(String[] words) {
//		List<List<Integer>> result = new ArrayList<>();
//		Map<String, Integer> dict = new HashMap<>();
//		for (int i = 0; i < words.length; i++) dict.put(words[i], i);
//		for (int i = 0; i < words.length; i++) {
//			for (int j = 0; j <= words[i].length(); j++) {
//				String sub1 = words[i].substring(0, j), sub2 = words[i].substring(j);
//				addPair(result, sub1, sub2, i, dict, false);
//				if (j != words[i].length()) 
//					addPair(result, sub2, sub1, i, dict, true);
//			}
//		}
//		return result;
//	}
//	
//	private void addPair(List<List<Integer>> result, String sub1, String sub2, int i, Map<String, Integer> dict, boolean reverse) {
//		if (isPalindrome(sub1)) {
//			String rev = new StringBuilder(sub2).reverse().toString();
//			if (dict.containsKey(rev) && dict.get(rev) != i) {
//				if (!reverse) result.add(Arrays.asList(dict.get(rev), i));
//				else result.add(Arrays.asList(i, dict.get(rev)));
//			}
//		}
//	}
//	
//	private boolean isPalindrome(String word) {
//		for (int i = 0, j = word.length() - 1; i < j; i++, j--) {
//			if (word.charAt(i) != word.charAt(j)) return false;
//		}
//		return true;
//	}
	
	// Trie solution, not finished yet
	// https://discuss.leetcode.com/topic/39585/o-n-k-2-java-solution-with-trie-structure-n-total-number-of-words-k-average-length-of-each-word/2
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> result = new ArrayList<>();
		TrieNode root = new TrieNode();
		for (int i = 0; i < words.length; i++) addWord(root, words[i], i);
		
		return result;
	}
	
	private void addWord(TrieNode root, String word, int index) {
		for (int i = word.length() - 1; i >= 0; i--) {
			int pos = word.charAt(i) - 'a';
			root.children[pos] = new TrieNode();
			root = root.children[pos];
		}
		root.index = index;
	}
	
	class TrieNode {
		TrieNode[] children;
		int index;
		boolean isWord;
		TrieNode() { children = new TrieNode[26]; index = -1; isWord = false; }
	}
	
	// There should be a SuffixArray solution, TBD
	
	public static void main(String[] args) {
		PalindromPairs pp = new PalindromPairs();
//		String[] words = {"a", ""}; // [[0, 1], [1, 0]]
		String[] words = {"a","b","c","ab","ac","aa"}; // [[3,0],[1,3],[4,0],[2,4],[5,0],[0,5]]
//		String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
		for (List<Integer> pair : pp.palindromePairs(words)) {
			for (int i : pair) { System.out.print(i); System.out.print(" "); }
			System.out.println("");
		}
	}
}
