import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllAnagramsInString {
//	public List<Integer> findAnagrams(String s, String p) {
//		List<Integer> result = new ArrayList<>();
//		int n = s.length(), k = p.length();
//		if (k == 0 || k > n) return result;
//		int[] dict = new int[26];
//		Set<Integer> set = new HashSet<>();
//		for (int i = 0; i < k; i++) {
//			dict[s.charAt(i) - 'a']++;
//			dict[p.charAt(i) - 'a']--;
//		}
//		for (int i = 0; i < 26; i++) {
//			if (dict[i] != 0) set.add(i);
//		}
//		if (set.isEmpty()) result.add(0);
//		for (int i = k; i < n; i++) {
//			int oc = s.charAt(i - k) - 'a';
//			int nc = s.charAt(i) - 'a';
//			dict[oc]--;
//			dict[nc]++;
//			if (dict[oc] == 0) set.remove(oc); else set.add(oc);
//			if (dict[nc] == 0) set.remove(nc); else set.add(nc);
//			if (set.isEmpty()) result.add(i - k + 1);
//		}
//		return result;
//	}
	
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		if (s == null || s.length() == 0 || p == null || p.length() == 0) return result;
		int[] hash = new int[256];
		for (int i = 0; i < p.length(); i++) hash[p.charAt(i)]++; 
		int l = 0, r = 0, count = p.length();
		while (r < s.length()) {
			if (hash[s.charAt(r)] >= 1) count--;
			hash[s.charAt(r)]--;
			r++;
			
			if (count == 0) result.add(l);
			
			if (r - l == p.length()) {
				if (hash[s.charAt(l)] >= 0) count++;
				hash[s.charAt(l)]++;
				l++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		FindAllAnagramsInString faais = new FindAllAnagramsInString();
		System.out.println(faais.findAnagrams("cbaebabacd", "abc"));
		System.out.println(faais.findAnagrams("abab", "ab"));
		System.out.println(faais.findAnagrams("baa", "aa"));
	}
}
