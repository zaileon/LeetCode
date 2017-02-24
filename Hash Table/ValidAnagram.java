
public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if (s == null && t == null) return true;
		if (s == null || t == null || s.length() != t.length()) return false;
		int[] count = new int[256];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i)]++;
			count[t.charAt(i)]--;
		}
		int distinct = 0;
		for (int i = 0; i < 256; i++) {
			if (count[i] != 0) distinct++;
		}
		return distinct == 0;
	}
	
	public static void main(String[] args) {
		ValidAnagram va = new ValidAnagram();
		System.out.println(va.isAnagram("anagram", "nagaram"));
		System.out.println(va.isAnagram("rat", "car"));
	}
}
