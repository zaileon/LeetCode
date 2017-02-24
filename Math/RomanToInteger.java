
public class RomanToInteger {

	int[] arr = {0,0,100,500,0,0,0,0,1,0,0,50,1000,0,0,0,0,0,0,0,0,5,0,10,0,0};
	public int romanToInt(String s) {
		int total = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (i < s.length() - 1 && arr[s.charAt(i + 1) - 'A'] > arr[c - 'A']) {
				total += arr[s.charAt(i + 1) - 'A'] - arr[c - 'A'];
				i++;
			} else {
				total += arr[c - 'A'];
			}
		}
		return total;
	}
	
	public static void main(String[] args) {
		RomanToInteger rtoi = new RomanToInteger();
		System.out.println(rtoi.romanToInt("MCMLIV")); // 1954
		System.out.println(rtoi.romanToInt("MCMXC")); // 1990
		System.out.println(rtoi.romanToInt("MMXIV")); // 2014
	}
}
