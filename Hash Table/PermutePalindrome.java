
public class PermutePalindrome {
	public boolean canPermutePalindrome(String s) {
		int[] count = new int[256];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i)]++;
		}
		int single = 0;
		for (int i = 0; i < 256; i++) {
			if ((count[i] & 1) == 1) single++;
		}
		return single <= 1;
	}
	
	public static void main(String[] args) {
		PermutePalindrome pp = new PermutePalindrome();
		System.out.println(pp.canPermutePalindrome(""));
		System.out.println(pp.canPermutePalindrome("code"));
		System.out.println(pp.canPermutePalindrome("aab"));
		System.out.println(pp.canPermutePalindrome("carerac"));
	}
}
