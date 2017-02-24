import java.util.Stack;

public class LongestValidParentheses {
//	public int longestValidParentheses(String s) {
//		s = ")" + s;
//		// longest stores the longest length of valid parentheses that ends at i
//		int[] longest = new int[s.length()];
//		int max = 0;
//		for (int i = 1; i < s.length(); i++) {
//			if (s.charAt(i) == '(') continue;
//			// if the matching character is '(', we can count longest[i] by adding
//			// longest[i-1] + 2 and longest[matching-1]    () (())   i = 5, longest[4]=2, matching = 2
//			// int matching = i - 1 - longest[i - 1];
//			if (s.charAt(i) == ')' && s.charAt(i - 1 - longest[i - 1]) == '(') {
//				longest[i] = longest[i - 1] + 2 + longest[i - longest[i - 1] - 2];
//				max = Math.max(max, longest[i]);
//			}
//		}
//		return max;
//	}
	
	// This method will get TLE if input is "((((....("
	public int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') stack.push(i);
			else {
				if (!stack.isEmpty()) {
					if (s.charAt(stack.peek()) == '(') stack.pop();
					else stack.push(i);
				} else {
					stack.push(i);
				}
			}
		}

		int len = 0;
		if (stack.isEmpty()) len = s.length();
		else {
			int end = s.length(), begin;
			while (!stack.isEmpty()) {
				begin = stack.pop();
				len = Math.max(len, end - begin - 1);
				end = begin;
			}
			len = Math.max(len, end);
		}
		return len;
	}
	
	public static void main(String[] args) {
		LongestValidParentheses lvp = new LongestValidParentheses();
		String s = "())";
//		String s = "()(()";
//		String s = ")(";
//		String s = ")()())";
		System.out.println(lvp.longestValidParentheses(s));
	}
}
