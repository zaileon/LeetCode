public class RearrangeStringKDistanceApart {
	
	public String rearrangeString(String s, int k) {
		int[] cnt = new int[26];
		for (int i = 0; i < s.length(); i++) {
			cnt[s.charAt(i) - 'a']++;
		}
		char[] cs = new char[s.length()];
		int[] idx = new int[26];
		for (int i = 0; i < s.length(); i++) {
			int c = nextValidMax(cnt, idx, i);
			if (c == -1) return "";
			cnt[c]--;
			idx[c] = i + k;
			cs[i]  = (char) ('a' + c); 
		}
		return new String(cs);
	}
	
	private int nextValidMax(int[] cnt, int[] idx, int index) {
		int max = 0, candidate = -1;
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] > max && index >= idx[i]) {
				candidate = i;
				max = cnt[i];
			}
		}
		return candidate;
	}

	public static void main(String[] args) {
		RearrangeStringKDistanceApart rskda = new RearrangeStringKDistanceApart();
		System.out.println(rskda.rearrangeString("aabbcc", 3)); // abcabc
		System.out.println(rskda.rearrangeString("aaabc", 3));  //
		System.out.println(rskda.rearrangeString("aaabc", 2));  // abaca
		System.out.println(rskda.rearrangeString("aaadbbcc", 2)); 
	}

}
