
public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] count = new int[256];
		for (int i = 0; i < magazine.length(); i++) count[magazine.charAt(i)]++;
		for (int i = 0; i < ransomNote.length(); i++) {
			char c = ransomNote.charAt(i);
			count[c]--;
			if (count[c] < 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		RansomNote rn = new RansomNote();
		System.out.println(rn.canConstruct("a", "b")); // false
		System.out.println(rn.canConstruct("aa", "ab")); // false
		System.out.println(rn.canConstruct("aa", "aab")); // true
	}
}
