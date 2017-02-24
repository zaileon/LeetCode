import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {
	
	private final static Set<Character> VOWELS = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));
	public String reverseVowels(String s) {
		char[] cs = s.toCharArray();
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			while (!VOWELS.contains(cs[i]) && i < j) i++;
			while (!VOWELS.contains(cs[j]) && i < j) j--;
			char c = cs[i];
			cs[i] = cs[j];
			cs[j] = c;
		}
		return new String(cs);
	}

	public static void main(String[] args) {
		ReverseVowels rv = new ReverseVowels();
		System.out.println(rv.reverseVowels("hello")); // holle
		System.out.println(rv.reverseVowels("leetcode")); // leotcede
		System.out.println(rv.reverseVowels("ae")); // ea
	}

}
