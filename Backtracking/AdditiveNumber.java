
public class AdditiveNumber {

	public boolean isAdditiveNumber(String num) {
		if (num.length() < 3) return false;
		int maxJ = num.charAt(0) == '0' ? 1 : num.length() / 2;
		for (int j = 1; j <= maxJ; j++) {
			int maxK = num.charAt(j) == '0' ? j + 1 : Math.min((num.length() + j) / 2, num.length() - j);
			for (int k = j + 1; k <= maxK; k++) {
				if (backtrack(num, 0, j, k)) return true;
			}
		}
		return false;
	}
	
	private boolean backtrack(String num, int i, int j, int k) {
		if (k >= num.length() && i != 0) return true;
		int len1 = j - i, len2 = k - j;	
		int minL = k + Math.max(len1, len2);
		int maxL = num.charAt(k) == '0' ? k + 1 : Math.min(num.length(), minL + 1);
		for (int l = minL; l <= maxL; l++) {
			if (isSum(num, i, j, k, l) && backtrack(num, j, k, l)) return true;
		}
		return false;
	}
	
	private boolean isSum(String num, int i, int j, int k, int l) {
		int carry = 0, sum, a, b, ll = l - 1;
		for (int jj = j - 1, kk = k - 1; jj >= i || kk >= j; jj--, kk--, ll--) {
			a = jj >= i ? num.charAt(jj) - '0' : 0;
			b = kk >= j ? num.charAt(kk) - '0' : 0;
			sum = a + b + carry;
			carry = sum / 10;
			sum %= 10;
			if (num.charAt(ll) - '0' != sum) return false;
		}
		return (ll == k && num.charAt(k) - '0' == carry) || ll == k - 1;
	}
	
	public static void main(String[] args) {
		AdditiveNumber an = new AdditiveNumber();
		System.out.println(an.isAdditiveNumber("100010")); // false
		System.out.println(an.isAdditiveNumber("199001200")); // false
		System.out.println(an.isAdditiveNumber("123")); // true
		System.out.println(an.isAdditiveNumber("01235")); // false
		System.out.println(an.isAdditiveNumber("10235")); // false
		System.out.println(an.isAdditiveNumber("1203")); // false
		System.out.println(an.isAdditiveNumber("112358")); // true
		System.out.println(an.isAdditiveNumber("199100199")); // true
		System.out.println(an.isAdditiveNumber("121474836472147483648")); // true
	}
}
