import java.util.Stack;

public class MiniParser {

	public NestedInteger deserialize(String s) {
		if (!s.startsWith("[")) return new NestedInteger(Integer.parseInt(s)); // special case, one Integer only
		
		Stack<NestedInteger> stack = new Stack<NestedInteger>();
		NestedInteger ni = new NestedInteger(); // add one extra layer
		
		for (int i = 0, j = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '[') {
				stack.push(ni);
				ni = new NestedInteger();
				j = i + 1;
			} else if (c == ',' || c == ']') {
				if (i > j) { // this is important because of "]," and "]]"
					Integer val = Integer.parseInt(s.substring(j, i));
					ni.add(new NestedInteger(val));
				}
				if (c == ']') {
					NestedInteger prev = stack.pop();
					prev.add(ni);
					ni = prev;
				}
				j = i + 1;
			}
		}
		return ni.getList().get(0); // strip off the extra layer
	}
	
	public static void main(String[] args) {
		MiniParser mp = new MiniParser();
//		String s = "123";
		String s = "[[]]"; // [[]]
//		String s = "[]"; // []
//		String s = "[123,[456,[789]]]";
		NestedInteger ni = mp.deserialize(s);
		printNestedInteger(ni);
	}
	
	private static void printNestedInteger(NestedInteger ni) {
		if (ni.isInteger()) 
			System.out.println(ni.val);
		else {
			for (NestedInteger i : ni.getList()) {
				printNestedInteger(i);
			}
		}
	}
}
