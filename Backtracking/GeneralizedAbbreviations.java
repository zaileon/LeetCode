import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviations {

	public List<String> generateAbbreviations(String word) {
		List<String> result = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		DFS(result, sb, word.toCharArray(), 0, 0);
		return result;
	}
	
	// for each char[i], two options:
	// abbreviate char[i]: num++, continue
	// not abbreviate char[i]: append num, then append char[i], restart num
	public void DFS(List<String> result, StringBuffer sb, char[] cs, int i, int num) {
		int len = sb.length();
		if (i == cs.length) {
			if (num != 0) sb.append(num);
			result.add(sb.toString());
		} else {
			DFS(result, sb, cs, i + 1, num + 1);  // abbreviate cs[i]
			if (num != 0) sb.append(num);         // not abbrevaite cs[i]
			DFS(result, sb.append(cs[i]), cs, i + 1, 0);
		}
		sb.setLength(len);
    }
	
	public static void main(String[] args) {
		GeneralizedAbbreviations ga = new GeneralizedAbbreviations();
		for (String s : ga.generateAbbreviations("word")) {
			System.out.println(s);
		}
	}
}
