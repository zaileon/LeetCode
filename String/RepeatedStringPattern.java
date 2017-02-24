
public class RepeatedStringPattern {

	// If S is repeated, say SpSp, we concat by S + S, but destroy the first Sp and the last Sp
	// It becomes SxSpSpSy (Sx - Sp[1:], Sy - Sp[:-1]), but S is embedded inside
	public boolean repeatedSubstringPattern(String str) {
		String s = str + str;
		String t = s.substring(1, str.length() * 2 - 1);
		return t.indexOf(str) >= 0;
	}
	
	public static void main(String[] args) {
		RepeatedStringPattern rsp = new RepeatedStringPattern();
		System.out.println(rsp.repeatedSubstringPattern("aaaa")); // true
		System.out.println(rsp.repeatedSubstringPattern("abac")); // false
		System.out.println(rsp.repeatedSubstringPattern("abab")); // true
		System.out.println(rsp.repeatedSubstringPattern("aba")); // false
		System.out.println(rsp.repeatedSubstringPattern("abacababacab")); // true
		System.out.println(rsp.repeatedSubstringPattern("abcabcabc")); // true
	}
}
