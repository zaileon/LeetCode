
public class ShortestWordDistance {
	public int shortestDistance(String[] words, String word1, String word2) {
		int min = Integer.MAX_VALUE, idx1 = -1, idx2 = -1;
		for (int i = 0; i < words.length; i++) {
			if (word1.equals(words[i])) {
				if (idx2 >= 0) min = Math.min(i - idx2, min);
				idx1 = i;
			} else if (word2.equals(words[i])) {
				if (idx1 >= 0) min = Math.min(i - idx1, min);
				idx2 = i;
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		ShortestWordDistance swd = new ShortestWordDistance();
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		String word1 = "makes", word2 = "coding";
//		String word1 = "coding", word2 = "practice";
		System.out.println(swd.shortestDistance(words, word1, word2));
	}
}
