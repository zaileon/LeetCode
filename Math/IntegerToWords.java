
public class IntegerToWords {
	private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private	final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
	
	public String numberToWords(int num) {
		if (num == 0) return "Zero";
		String number = "";
		int i = 0;
		while (num > 0) {
			if (num % 1000 != 0) {
				number = helper(num % 1000) + THOUSANDS[i] + " " + number;
			}
			num /= 1000;
			i++;
		}
		return number.trim();
	}
	
	private String helper(int num) {
		if (num == 0) 
			return "";
		else if (num < 20)
			return LESS_THAN_20[num] + " ";
		else if (num < 100)
			return TENS[num / 10] + " " + helper(num % 10);
		else
			return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
	}

	public static void main(String[] args) {
		IntegerToWords itow	 = new IntegerToWords();
		System.out.println(itow.numberToWords(50868));
		System.out.println(itow.numberToWords(1234567));
	}

}
