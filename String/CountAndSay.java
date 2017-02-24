
public class CountAndSay {
	public String countAndSay(int n) {
		if (n <= 0) return "";
		StringBuilder sb = new StringBuilder();
		String s = "1";
		for (int i = 1; i < n; i++) {
			int count = 1, digit = s.charAt(0) - '0';
			for (int j = 1; j <= s.length(); j++) {
				if (j == s.length() || digit != s.charAt(j) - '0') {
					sb.append(count);
					sb.append(digit);
					if (j < s.length()) {
						digit = s.charAt(j) - '0';
						count = 1;
					}
				} else count++;
			}
			s = sb.toString();
			sb.setLength(0);
		}
		return s;
	}

	public static void main(String[] args) {
		CountAndSay cas = new CountAndSay();
		int n = 1;
		System.out.println(cas.countAndSay(n));
	}

}
