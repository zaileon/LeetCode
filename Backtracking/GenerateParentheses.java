import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	
	public List<String> generateParenthese(int n) {
		List<String> result = new ArrayList<>();
		char[] sample = new char[n * 2];
		backtrack(result, sample, 0, 0);
		return result;
	}
	
	private void backtrack(List<String> result, char[] s, int open, int close) {
		if (open + close == s.length) {
			result.add(new String(s));
			return;
		}
		if (open < s.length / 2) { 
			s[open + close] = '(';
			backtrack(result, s, open + 1, close);
		}
		if (close > open) { 
			s[open + close] = ')';
			backtrack(result, s, open, close + 1);
		}
	}

	public static void main(String[] args) {
		GenerateParentheses gp = new GenerateParentheses();
		int n = 3;
		for (String s : gp.generateParenthese(n)) {
			System.out.println(s);
		}
	}

}
