
public class RemoveDuplicateLetters {

	public String removeDuplicateLetters(String s) {
		int[] cnts = new int[26];
		boolean[] flag = new boolean[26];
		for (int i = 0; i < s.length(); i++) {
			cnts[s.charAt(i) - 'a']++;
		}
		char[] stack = new char[s.length()];
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!flag[c - 'a']) {
				while (j > 0 && c < stack[j - 1] && cnts[stack[j - 1] - 'a'] > 0) {
					flag[stack[j - 1] - 'a'] = false;
					j--;
				}
				stack[j++] = c;
				flag[c - 'a'] = true;
			}
			cnts[c - 'a']--;
		}
		return new String(stack, 0, j);
	}
	
	public static void main(String[] args) {
		RemoveDuplicateLetters rdl = new RemoveDuplicateLetters();
		System.out.println(rdl.removeDuplicateLetters("bbcaac")); // bac
		System.out.println(rdl.removeDuplicateLetters("bcabc")); // abc
		System.out.println(rdl.removeDuplicateLetters("cbacdcbc")); // acdb
	}
}
