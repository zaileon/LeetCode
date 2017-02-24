
public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
		if (s.length() > t.length()) return false;
		if (s.length() == 0) return true;
		int prev = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			prev = t.indexOf(c, prev);
			if (prev < 0) return false; 
			prev++;
		}
		return true;
	}
	
	public static void main(String[] args) {
		IsSubsequence is = new IsSubsequence();
//		String s = "abc", t = "ahbgdc";
//		String s = "abc", t = "ahbgdc";
		String s = "axc", t = "ahbgdc";
		System.out.println(is.isSubsequence(s, t));
	}
}
