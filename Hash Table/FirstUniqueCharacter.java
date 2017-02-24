import java.util.Arrays;

public class FirstUniqueCharacter {

	// the most voted answer at Leetcode pass through the string twice, while this method is O + 2 * 26.
	public int firstUniqChar(String s) {
		int[] idx = new int[26];
		Arrays.fill(idx, -1);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			idx[c - 'a'] = idx[c - 'a'	] < 0 ? i : Integer.MAX_VALUE; 
		}
		int ret = Integer.MAX_VALUE;
		for (int i = 0; i < 26; i++) {
			if (idx[i] >= 0 && idx[i] < ret) ret = idx[i];
		}
		return ret == Integer.MAX_VALUE ? -1 : ret;
	}
	
	
	public static void main(String[] args) {
		FirstUniqueCharacter fuc = new FirstUniqueCharacter();
		System.out.println(fuc.firstUniqChar("leetcode"));
		System.out.println(fuc.firstUniqChar("loveleetcode"));
	}
}
