import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
	
	public List<List<String>> groupStrings(String[] strings) {
		if (strings.length == 0) return new ArrayList<>();
		Map<String, List<String>> dict = new HashMap<>();
		for (String s : strings) {
			char[] cs = s.toCharArray();
			int gap = cs[0] - 'a';
			for (int i = 0; i < cs.length; i++) {
				cs[i] = (char) (cs[i] - gap);
				if (cs[i] < 'a') cs[i] += 26;
			}
			String key = new String(cs);
			dict.putIfAbsent(key, new ArrayList<String>());
			dict.get(key).add(s);
		}
		return new ArrayList<>(dict.values());
	}

	public static void main(String[] args) {
		GroupShiftedStrings gss = new GroupShiftedStrings();
		String[] strings = new String[] { "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z" };
		for (List<String> list : gss.groupStrings(strings)) {
			for (String s : list) {
				System.out.print(s + " ");
			}
			System.out.println("");
		}
	}

}
