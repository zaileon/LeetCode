import java.util.Stack;

public class MinStack {
	private Stack<Integer> stack;
	private Stack<Integer> minStack;
	
	public MinStack() {
		stack = new Stack<>();
		minStack = new Stack<>();
	}
	
	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty() || x <= minStack.peek()) minStack.push(x);
	}
	
	public void pop() {
		int x = stack.pop();
		if (minStack.peek() == x) minStack.pop();
	}
	
	public int top() {
		return stack.peek();
	}
	
	public int getMin() {
		return minStack.peek();
	}
	
	public static void main(String[] args) {
		MinStack s = new MinStack();
		s.push(-3);
		s.push(2);
		System.out.println(s.getMin());
		s.push(-3);
		s.pop();
		System.out.println(s.getMin());
	}
}
