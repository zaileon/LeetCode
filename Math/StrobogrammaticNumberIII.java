
public class StrobogrammaticNumberIII {
	
	private static final char[][] pairs = {{'0','0'},{'1','1'},{'6','9'},{'8','8'},{'9','6'}};
	private int count = 0;
	public int strobogrammaticInRange(String low, String high) {
		for (int len = low.length(); len <= high.length(); len++) {
			char[] arr = new char[len];
			dfs(low, high, arr, 0, len - 1);
		}
		return count;
	}
	
	public void dfs(String low, String high, char[] c, int left, int right) {
		if (left > right) {
			String s = new String(c);
			// "69" is greater than "100", so only when s is the same length as low/high, the comparison is correct
			if ((s.length() == low.length() && s.compareTo(low) < 0) || 
				(s.length() == high.length() && s.compareTo(high) > 0)) return;
			count++;
			return;
		}
		for (char[] p : pairs) {
			c[left] = p[0];
			c[right] = p[1];
			if (c.length != 1 && c[0] == '0') continue;
			if (left == right && p[0] != p[1]) continue;
			dfs(low, high, c, left + 1, right - 1);
		}
	}

	public static void main(String[] args) {
		StrobogrammaticNumberIII sn = new StrobogrammaticNumberIII();
		System.out.println(sn.strobogrammaticInRange("50", "100"));
	}

}
