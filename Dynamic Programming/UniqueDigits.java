
public class UniqueDigits {

	public int countNumbersWithUniqueDigits(int n) {
		if (n == 0) return 1;
		int sum = 10;
		int uniqueDigits = 9;    // number of unique digits with n digits
		int availableNumber = 9;
		while(n > 1 && availableNumber > 0) {
			uniqueDigits = uniqueDigits * availableNumber;
			sum += uniqueDigits;
			availableNumber--;
			n--;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		UniqueDigits ud = new UniqueDigits();
		int n = 2;
		System.out.println(ud.countNumbersWithUniqueDigits(n));
	}

}
