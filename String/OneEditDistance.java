
public class OneEditDistance {
	
//	public boolean isOneEditDistance(String s, String t) {
//		if (s.length() > t.length()) return isOneEditDistance(t, s);
//		int len1 = s.length(), len2 = t.length();
//		if (len2 - len1 > 1) return false;
//		int i = 0, j = 0;
//		while (i < len1 && s.charAt(i) == t.charAt(i)) i++;
//		if (i == len1 && j == len2) return false;
//		if (len1 == len2) { i++; j = i; }
//		else j = i + 1;
//		while (j < len2 && s.charAt(i) == t.charAt(j)) {
//			i++; j++;
//		}
//		return j == len2;
//	}
	
	public boolean isOneEditDistance(String s, String t) {
		int m = s.length(), n = t.length();
		if (Math.abs(m - n) > 1) return false;
		for (int i = 0; i < Math.min(m, n); i++) {
			if (s.charAt(i) != t.charAt(i)) {
				if (m == n) return s.substring(i + 1).equals(t.substring(i + 1));
				else if (m < n) return s.substring(i).equals(t.substring(i + 1));
				else return s.substring(i + 1).equals(t.substring(i));
			}
		}
		return m != n;
	}

	public static void main(String[] args) {
		OneEditDistance oed = new OneEditDistance();
		System.out.println(oed.isOneEditDistance("a", ""));
		System.out.println(oed.isOneEditDistance("", ""));
	}

}
