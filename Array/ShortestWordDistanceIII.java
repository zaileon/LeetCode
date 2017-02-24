
public class ShortestWordDistanceIII {
//	public int shortestDistance(String[] words, String word1, String word2) {
//		long distance = Integer.MAX_VALUE, i1 = distance, i2 = -distance;
//		boolean same = word1.equals(word2);
//		for (int i = 0; i < words.length; i++) {
//			if (words[i].equals(word1)) i1 = i;
//			if (words[i].equals(word2)) {
//				if (same) i1 = i2;
//				i2 = i;
//			}
//			distance = Math.min(distance, Math.abs(i2 - i1));
//		}
//		return (int) distance;
//	}
	
	public int shortestDistance(String[] words, String word1, String word2) {
		int n = words.length, distance = n, i1 = n, i2 = -n;
		boolean same = word1.equals(word2);
		for (int i = 0; i < n; i++) {
			if (same && words[i].equals(word1)) {
				i1 = i2;
				i2 = i;
			} else if (!same) {
				if (words[i].equals(word1)) i1 = i;
				else if (words[i].equals(word2)) i2 = i;
			} else continue;
			distance = Math.min(distance, Math.abs(i2 - i1));
		}
		return distance;
	}
	
	public static void main(String[] args) {
		ShortestWordDistanceIII swd = new ShortestWordDistanceIII();
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		String word1 = "coding", word2 = "practice";
//		String word1 = "makes", word2 = "coding";
//		String word1 = "makes", word2 = "makes";
		System.out.println(swd.shortestDistance(words, word1, word2));
	}
}
