import java.util.ArrayList;
import java.util.List;

public class FlipGame {

	public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
		char[] cs = s.toCharArray();
		for (int i = 1, j = 0; i < s.length(); i++) {
			if (cs[i] == cs[j] && cs[i] == '+') {
				cs[i] = cs[j] = '-';
				result.add(new String(cs));
				cs[i] = cs[j] = '+';
			}
			j = i;
		}
		return result;
    }
	
//	public List<String> generatePossibleNextMoves(String s) {
//		List<String> result = new ArrayList<>();
//		for (int i = -1; (i = s.indexOf("++", i + 1)) >= 0; ) {
//			result.add(s.substring(0, i) + "--" + s.substring(i + 2));
//		}
//		return result;
//	}
	
	
	public static void main(String[] args) {
		FlipGame fg = new FlipGame();
//		String s = "--++";
//		String s = "+--+";
		String s = "--";
//		String s = "++++";
		for (String s1 : fg.generatePossibleNextMoves(s)) {
			System.out.println(s1);
		}
	}
}
