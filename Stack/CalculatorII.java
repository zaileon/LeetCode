import java.util.Stack;

public class CalculatorII {
	
	public int calculate(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int n = 0;
		char sign = '+';
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				n = n * 10 + c - '0';
			} else if (c != ' '){
				calc(stack, sign, n);
				sign = c;
				n = 0;
			}
		}
		calc(stack, sign, n);
		int result = 0;
		while (!stack.isEmpty()) result += stack.pop();
		return result;
	}
	
	private void calc(Stack<Integer> stack, char sign, int n) {
		if (sign == '+') stack.push(n);
		else if (sign == '-') stack.push(-n);
	 	else if (sign == '*') stack.push(stack.pop() * n);
	 	else if (sign == '/') stack.push(stack.pop() / n);
	}
	
	public static void main(String[] args) {
		CalculatorII c = new CalculatorII();
		System.out.println(c.calculate("3+2*2")); // 7
		System.out.println(c.calculate("  3/2")); // 1
		System.out.println(c.calculate(" 3+5 / 2 ")); // 5
	}
}
