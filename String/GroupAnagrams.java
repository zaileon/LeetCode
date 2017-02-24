import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			String hash = hash(str);
			if (!map.containsKey(hash)) {
				map.put(hash, new ArrayList<String>());
			}
			map.get(hash).add(str);
		}
		List<List<String>> result = new ArrayList<>();
		for (String key : map.keySet()) {
			result.add(map.get(key));
		}
		return result;
	}
	
	private String hash(String str) {
		char[] cs = str.toCharArray();
		Arrays.sort(cs);
		return new String(cs);
	}

	public static void main(String[] args) {
		GroupAnagrams ga = new GroupAnagrams();
		String[] strs = {"", "eat", "tea", "tan", "ate", "nat", "bat"};
		for (List<String> list : ga.groupAnagrams(strs)) {
			for (String s : list) {
				System.out.print(s);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}

}
