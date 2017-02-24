import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
	
	public boolean isValid(String s) {
		if (s == null || s.length() == 0) return true;
		Deque<Character> stack = new ArrayDeque<>();
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '[' || c == '{')
				stack.offer(c);
			else {
				if (stack.isEmpty() ||
					(c == ')' && stack.peekLast() != '(') || 
					(c == ']' && stack.peekLast() != '[') ||
					(c == '}' && stack.peekLast() != '{'))
					return false;
				stack.removeLast();
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		ValidParentheses vp = new ValidParentheses();
		String s = "([])";
		System.out.println(vp.isValid(s));
	}

}
