
public class ReversePolishNotation {
	public int evalRPN(String[] tokens) {
		int[] res = new int[tokens.length];
		int j = 0;
		for (int i = 0; i < tokens.length; i++) {
			switch(tokens[i]) {
				case "+":
				case "-":
				case "*":
				case "/":
					int i2 = res[--j];
					int i1 = res[--j];
					res[j++] = calculate(i1, i2, tokens[i]);
					break;
				default: 	
					res[j++] = Integer.parseInt(tokens[i]);
			}
		}
		return res[--j];
	}
	
	private int calculate(int i1, int i2, String operator) {
		if ("+".equals(operator)) return i1 + i2;
		else if ("-".equals(operator)) return i1 - i2;
		else if ("*".equals(operator)) return i1 * i2;
		else return i1 / i2;
	}
	
	public static void main(String[] args) {
		ReversePolishNotation rpn = new ReversePolishNotation();
		String[] tokens = new String[] {"4","13","5","/","+"};
//		String[] tokens = new String[] {"2","1","+","3","*"};
		System.out.println(rpn.evalRPN(tokens));
	}
}
