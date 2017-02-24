import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortCharactersByFreq {
//	public String frequencySort(String s) {
//		int[] dict = new int[256];
//		for (int i = 0; i < s.length(); i++) dict[s.charAt(i)]++;
//		PriorityQueue<Character> pq = new PriorityQueue<Character>((c1, c2) -> {
//			return dict[c2] != dict[c1] ? dict[c2] - dict[c1]: c2 - c1;
//		});
//		for (int i = 0; i < s.length(); i++) {
//			pq.add(s.charAt(i));
//		}
//		StringBuilder sb = new StringBuilder();
//		while (!pq.isEmpty()) {
//			sb.append(pq.poll());
//		}
//		return sb.toString();
//	}
	
	public String frequencySort(String s) {
		int[] dict = new int[256];
		for (int i = 0; i < s.length(); i++) dict[s.charAt(i)]++;
		TreeMap<Integer, List<Character>> map = new TreeMap<>();
		for (int i = 0; i < 256; i++) {
			if (dict[i] > 0) {
				if (!map.containsKey(dict[i])) {
					map.put(dict[i], new ArrayList<>());
				}
				map.get(dict[i]).add((char)i);
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!map.isEmpty()) {
			Map.Entry<Integer, List<Character>> entry = map.pollLastEntry();
			for (Character ch : entry.getValue()) {
				sb.append(new String(new char[entry.getKey()]).replace('\0', ch));
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		SortCharactersByFreq scbf = new SortCharactersByFreq();
		System.out.println(scbf.frequencySort("tree"));
		System.out.println(scbf.frequencySort("cccaaa"));
		System.out.println(scbf.frequencySort("Aabb"));
	}
}
