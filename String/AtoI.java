
public class AtoI {

	public static void main(String[] args) {
		AtoI a2i = new AtoI();
		System.out.println(a2i.myAtoi("123"));  // 123
		System.out.println(a2i.myAtoi("+-2"));   // 0
		System.out.println(a2i.myAtoi("-0"));   // 0
		System.out.println(a2i.myAtoi("+0"));   // 0
		System.out.println(a2i.myAtoi("12 3")); // 12
		System.out.println(a2i.myAtoi("  -0012a42")); // 12
		System.out.println(a2i.myAtoi("21474836471")); // 2147483647
		System.out.println(a2i.myAtoi("2147483648")); // 2147483647
		System.out.println(a2i.myAtoi("-2147483647")); // -2147483647
		System.out.println(a2i.myAtoi("-2147483648")); // -2147483648
		System.out.println(a2i.myAtoi("-2147483649")); // -2147483648
		System.out.println(a2i.myAtoi("      -11919730356x")); // -2147483648
	}

	public int myAtoi(String str) {
		long num = 0;
		boolean neg = false, start = false;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if ((c < '0' || c > '9') && c != '+' && c != '-' && c != ' ') break; 
			if (c == ' ') {
				if (start) break;
				else continue;
			}
			if (c == '+' || c == '-') { 
				if (start) { num = 0; break; }
				else { start = true;  neg = c == '-'; continue; }
			}
			num = num * 10 + c - '0';
			if (num > Integer.MAX_VALUE) break;
			if (!start) start = true;
		}
		if (neg) num = Math.max(-num, Integer.MIN_VALUE);
		else num = Math.min(num, Integer.MAX_VALUE);
		return (int) num;
	}

}
