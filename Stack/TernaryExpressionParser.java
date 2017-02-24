
public class TernaryExpressionParser {

	public String parseTernary(String expression) {
		return dfs(expression, 0);
	}
	
	// think of '?' as left parenthesis and ':' as right parenthesis
	// if the condition is 'T', directly start from start + 2
	// if the condition is 'F', skip the entire true branch by find the next unmatched ':'
	private String dfs(String expression, int start) {
		char c = expression.charAt(start);
		// since number only has one digit, we know that if the next char is not '?', we get the answer
		// need to consider the edge case when start is at the end
		if (start == expression.length() - 1 || expression.charAt(start + 1)  != '?') {
			return expression.substring(start, start + 1);
		} else {
			if (c == 'F') {
				int count = 1, i = start + 1;
				while (count != 0) {
					i += 2; // always skip one T|F
					count += expression.charAt(i) == '?' ? 1 : -1;
				}
				return dfs(expression, i + 1);
			} else {
				return dfs(expression, start  + 2);
			}
		}
	}
	
	public static void main(String[] args) {
		TernaryExpressionParser tep = new TernaryExpressionParser();
		System.out.println(tep.parseTernary("F?T?F:T?1:F:3")); // 3
		System.out.println(tep.parseTernary("T?F?1:T?2:3T?4:5")); // 2
		System.out.println(tep.parseTernary("F?F?1:T?2:3:T?4:5")); // 4
		System.out.println(tep.parseTernary("T?T?F:5:3")); // F
	}
}
