
public class PlusOne {
	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) return new int[0];
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry > 0) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            digits = newDigits;
        }
        return digits;
    }
	
	public static void main(String[] args) {
		PlusOne po = new PlusOne();
		int[] digits = {9};
//		int[] digits = {3,7,9};
		for (int n : po.plusOne(digits)) {
			System.out.println(n);
		}
	}
}
