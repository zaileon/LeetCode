import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		List<String> res = new ArrayList<String>();
		backtracking(s, 0, res, result);
		return result;
	}
	
	private void backtracking(String s, int idx, List<String> res, List<List<String>> result) {
		if (idx == s.length()) {
			result.add(new ArrayList<String>(res)); // copy to a new List
			return;
		}
		for (int i = idx + 1; i <= s.length(); i++) {
			String sub = s.substring(idx, i);
			if (isPalindrome(sub)) {
				res.add(sub);
				backtracking(s, i, res, result);
				res.remove(res.size() - 1);
			}
		}
	}
	
	private boolean isPalindrome(String sub) {
		int i = 0, j = sub.length() - 1;
		while(i < j) {
			if (sub.charAt(i) != sub.charAt(j)) return false;
			i++; j--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		PalindromePartitioning pp = new PalindromePartitioning();
		String s = "aab";
		for (List<String> list : pp.partition(s)) {
			for (String str : list) {
				System.out.print(str);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
}
