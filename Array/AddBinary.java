
public class AddBinary {
	public String addBinary(String a, String b) {
		StringBuilder builder = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1, carry = 0;
		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (j >= 0) sum += b.charAt(j--) - '0';
			if (i >= 0) sum += a.charAt(i--) - '0';
			builder.append(sum & 1);
			carry = sum >> 1;
		}
		if (carry != 0) builder.append('1');
		return builder.reverse().toString();
	}
	
	public static void main(String[] args) {
		AddBinary addBinary = new AddBinary();
		String a = "11", b = "111";
		System.out.println(addBinary.addBinary(a, b));
	}
}
