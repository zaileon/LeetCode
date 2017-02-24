
public class ReverseWords {
	public String reverseWords(String s) {
		char[] cs = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		reverse(cs, 0, s.length() - 1);
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			if (cs[i] == ' ' && cs[start] != ' ') {
				reverse(cs, start, i - 1);
				if (sb.length() > 0) sb.append(' ');
				sb.append(new String(cs, start, i - start));
				start = i;
			} else if (cs[start] == ' ') {
				start = i;
			}
		}
		if (start < cs.length && cs[start] != ' ') {
			reverse(cs, start, cs.length - 1);
			if (sb.length() > 0) sb.append(' ');
			sb.append(new String(cs, start, cs.length - start));
		}
		return sb.toString();
	}
	
	private void reverse(char[] cs, int lo, int hi) {
		while (lo < hi) {
			char c = cs[lo];
			cs[lo] = cs[hi];
			cs[hi] = c;
			lo++;
			hi--;
		}
	}
	
	public static void main(String[] args) {
		ReverseWords rw = new ReverseWords();
//		String s = "   a   b ";
//		String s = "1 ";
//		String s = " 1";
		String s = "the   sky is blue";
		System.out.println(rw.reverseWords(s));
	}

}
