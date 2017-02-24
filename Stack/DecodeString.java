import java.util.Stack;

public class DecodeString {

	public String decodeString(String s) {
		Stack<String> strs = new Stack<>();
		Stack<Integer> reps = new Stack<>();
		String curr = "";  // curr: prefix + num [ curr ] + suffix
		int n = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				n = n * 10 + s.charAt(i) - '0';
			} else if (c == '[') {
				reps.push(n);
				strs.push(curr);
				curr = ""; // save prefix and reset curr
				n = 0;
			} else if (c == ']') {
				StringBuilder temp = new StringBuilder(strs.pop());
				for (n = reps.pop(); n > 0; n--) temp.append(curr);
				curr = temp.toString();
			} else {
				curr += c; // letters in prefix/suffix are directly appended
			}
		}
		return curr;
	}
	
	public static void main(String[] args) {
		DecodeString ds = new DecodeString();
//		System.out.println(ds.decodeString("3[a]2[bc]"));
		System.out.println(ds.decodeString("3[a2[c]]"));
//		System.out.println(ds.decodeString("2[abc]3[cd]ef"));
	}
}
