import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
	
	// every time see an extra ')', remove the first ')' in a continuous series of ')', use last_j to record last removed position
	// if we have more '(' than ')', do it reversely by switching both s and the pair. Really BRILLIANT!!
	public List<String> removeInvalidParentheses(String s) {
		List<String> result = new ArrayList<>();
		remove(s, result,  0, new char[] { '(', ')' });
		return result;
	}

	private void remove(String s, List<String> result, int last_j, char[] par) {
		for (int i = 0, count = 0; i < s.length(); i++) {
			if (s.charAt(i) == par[0]) count++;
			if (s.charAt(i) == par[1]) count--;
			if (count >= 0) continue;
			for (int j = last_j; j <= i; ++j) {
				if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
					remove(s.substring(0, j) + s.substring(j + 1), result, j, par);
			}
			return;
		}
		String reversed = new StringBuilder(s).reverse().toString();
		if (par[0] == '(') remove(reversed, result, 0, new char[] { ')', '(' });
		else result.add(reversed);
	}
	
//	public List<String> removeInvalidParentheses(String s) {
//		List<String> result = new ArrayList<>();
//		
//		Queue<String> queue = new LinkedList<>();
//		Set<String> set = new HashSet<>();
//		
//		queue.offer(s);
//		set.add(s);
//		boolean found = false;
//		
//		while (!queue.isEmpty()) {
//			String str = queue.poll();
//			if (isValid(str)) {
//				found = true;
//				result.add(str);
//			}
//			// we found the valid longest string, no need to continue n-1 length substrings
//			// but still need to finish rest of the queue
//			if (found) continue; 
//			for (int i = 0; i < str.length(); i++) {
//				if (str.charAt(i) != '(' && str.charAt(i) != ')') continue;
//				String ss = str.substring(0, i) + str.substring(i + 1);
//				if (!set.contains(ss)) {
//					set.add(ss);
//					queue.add(ss);
//				}
//			}
//		}
//		return result;
//	}
	
	public boolean isValid(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') count++;
			else if (str.charAt(i) == ')') {
				if (count == 0) return false;
				count--;
			}
		}
		return count == 0;
	}
	
	public static void main(String[] args) {
		RemoveInvalidParentheses rip = new RemoveInvalidParentheses();
//		String s = ")(";
//		String s = "(a)())()";
		String s = "(()(()";
//		String s = "()())()";
		for (String str : rip.removeInvalidParentheses(s)) {
			System.out.println(str);
		}
	}

}
