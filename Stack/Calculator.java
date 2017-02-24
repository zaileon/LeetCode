import java.util.Stack;

public class Calculator {

	public int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		int n = 0, curr = 0;
		int sign = 1;
		stack.push(sign);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				n = n * 10 + c - '0';
			} else if (c == '+' || c == '-') {
				curr += sign * n;
				sign = stack.peek() * (c == '+' ? 1 : -1);
				n = 0;
			} else if (c == '(') {
				stack.push(sign);
			} else if (c == ')') {
				stack.pop();
			}
		}
		return curr + sign * n;
	}
	
	public static void main(String[] args) {
		Calculator c = new Calculator();
//		System.out.println(c.calculate("1 + 1")); // 2
//		System.out.println(c.calculate(" 2-1 + 2 ")); // 3
		System.out.println(c.calculate("(1+(4+5+2)-3)+(6+8)")); // 23
	}
}
