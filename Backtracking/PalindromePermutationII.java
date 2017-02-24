import java.util.ArrayList;
import java.util.List;

public class PalindromePermutationII {
	
	public List<String> generatePalindromes(String s) {
		int[] counts = new int[256];
		List<String> result = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) counts[s.charAt(i)]++;
		char c = '\0';
		for (int i = 0; i < 256; i++) {
			if ((counts[i] & 1) == 1) {
				if (c != '\0') return result;
				c = (char) i;
			}
			counts[i] = counts[i] >> 1;
		}
		backtrack(new char[s.length()], 0, s.length(), c, counts, result);
		return result;
	}
	
	private void backtrack(char[] cs, int start, int N, char c, int[] counts, List<String> result) {
		if (start == N / 2) {
			for (int i = start; i < N; i++) {
				if (c != '\0' && i == start) cs[i] = c;
				else cs[i] = cs[N - 1 - i];
			}
			result.add(new String(cs));
			return;
		}
		for (int i = 0; i < 256; i++) {
			if (counts[i] > 0) {
				cs[start] = (char) i;
				counts[i]--;
				backtrack(cs, start + 1, N, c, counts, result);
				counts[i]++;
			}
		}
	}

	public static void main(String[] args) {
		PalindromePermutationII pp = new PalindromePermutationII();
//		String s = "abc";
		String s = "aabb";
//		String s = "aabbb";
		for (String ss : pp.generatePalindromes(s)) {
			System.out.println(ss);
		}
	}

}
