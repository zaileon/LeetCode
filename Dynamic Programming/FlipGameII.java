import java.util.HashMap;
import java.util.Map;

public class FlipGameII {
	
	Map<String, Boolean> memo = new HashMap<String, Boolean>();
	public boolean canWin(String s) {
		if (memo.containsKey(s)) return memo.get(s);
		char[] cs = s.toCharArray();
		for (int i = 0; i < s.length() - 1; i++) {
			if (cs[i] == cs[i + 1] && cs[i] == '+') {
				cs[i] = cs[i + 1] = '-';
				if (!canWin(new String(cs))) {
					cs[i] = cs[i + 1] = '+';
					memo.put(s, true);
					return true;
				}
				cs[i] = cs[i + 1] = '+';
			}
		}
		memo.put(s, false);
		return false;
	}

	public static void main(String[] args) {
		FlipGameII fg = new FlipGameII();
		String s = "++++";
		System.out.println(fg.canWin(s));
	}

}
