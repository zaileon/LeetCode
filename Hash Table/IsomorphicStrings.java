
public class IsomorphicStrings {
	
	public boolean isIsomorphic(String s, String t) {
		int[] map = new int[512];
		for (int i = 0; i < s.length(); i++) {
			int u = s.charAt(i), v = t.charAt(i); 
			if (map[u] != map[v + 256]) return false;
			map[u] = map[v + 256] = i + 1;
		}
		return true;
	}

	// for some reason, doesn't pass the test(s="aa",t="ab")
//	public boolean isIsomorphic(String s, String t) {
//		int[] map = new int[256];
//		for (int i = 0; i < s.length(); i++) {
//			int u = s.charAt(i), v = t.charAt(i);
//			if (map[u] == 0) map[u] = v + 1;
//			else if (map[u] != v + 1) return false;
//		}
//		return true;
//	}

	public static void main(String[] args) {
		IsomorphicStrings is = new IsomorphicStrings();
		System.out.println(is.isIsomorphic("aa", "ab"));
		System.out.println(is.isIsomorphic("egg", "add"));
		System.out.println(is.isIsomorphic("foo", "bar"));
		System.out.println(is.isIsomorphic("paper", "title"));
	}

}
