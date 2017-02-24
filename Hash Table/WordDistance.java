import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDistance {
	
	private Map<String, List<Integer>> positions = new HashMap<>();
	
	public WordDistance(String[] words) {
		for (int i = 0; i < words.length; i++) {
			if (!positions.containsKey(words[i])) {
				positions.put(words[i], new ArrayList<Integer>());
			}
			positions.get(words[i]).add(i);
		}
	}
	
	public int shortest(String word1, String word2) {
		List<Integer> pos1 = positions.get(word1);
		List<Integer> pos2 = positions.get(word2);
		int distance = Integer.MAX_VALUE;
		for (int i = 0, j = 0; i < pos1.size() && j < pos2.size();) {
			if (pos1.get(i) < pos2.get(j)) distance = Math.min(pos2.get(j) - pos1.get(i++), distance);
			else distance = Math.min(pos1.get(i) - pos2.get(j++), distance);
		}
		return distance;
	}
	
	public static void main(String[] args) {
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		WordDistance wd = new WordDistance(words);
		System.out.println(wd.shortest("coding", "practice"));
		System.out.println(wd.shortest("makes", "coding"));
	}
}
