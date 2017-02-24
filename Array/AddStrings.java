
public class AddStrings {
	public String addStrings(String num1, String num2) {
		int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
		StringBuilder sb = new StringBuilder(Math.max(i, j) + 2);
		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (i >= 0) sum += num1.charAt(i--) - '0';
			if (j >= 0) sum += num2.charAt(j--) - '0';
			carry = sum / 10;
			sb.append(sum % 10);
		}
		if (carry != 0) sb.append('1');
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		
	}
}
