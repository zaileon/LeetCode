
public class ReverseWordsII {
	
	public void reverseWords(char[] s) {
		reverse(s, 0, s.length - 1);
		int j = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i] == ' ') {
				reverse(s, j, i - 1);
				j = i + 1;
			}
		}
		reverse(s, j, s.length - 1);
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
		ReverseWordsII rw = new ReverseWordsII();
		String s = "the sky is blue";
//		String s = "the";
//		String s = "";
		rw.reverseWords(s.toCharArray());
	}

}
