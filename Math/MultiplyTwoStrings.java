
public class MultiplyTwoStrings {
	
	public String multiply(String num1, String num2) {
		int m = num1.length(), n = num2.length();
		char[] result = new char[m + n];
		int sum = 0;
		for (int k = m + n - 1; k >= 0; k--) {
			for (int i = Math.min(m - 1, k - 1); i >= Math.max(0, k - n); i--) {
				sum += (num1.charAt(i) - '0') * (num2.charAt(k - i - 1) - '0');
			}
			result[k] = (char)(sum % 10 + '0');
			sum /= 10;
		}
		int offset = 0;
		while (offset < m + n && result[offset] == '0') offset++;
		return offset < m + n ? new String(result, offset, m + n - offset) : "0";
	}

	public static void main(String[] args) {
		MultiplyTwoStrings ms = new MultiplyTwoStrings();
		System.out.println(ms.multiply("0", "0"));
//		System.out.println(ms.multiply("12345", "6789"));
	}

}
