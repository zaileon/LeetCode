import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
	
//	static Map<Integer, String> dict;
//	static {
//		dict = new HashMap<>();
//		dict.put(1, "I");
//		dict.put(4, "VI");
//		dict.put(5, "V");
//		dict.put(9, "XI");
//		dict.put(10, "X");
//		dict.put(40, "LX");
//		dict.put(50, "L");
//		dict.put(90, "CX");
//		dict.put(100, "C");
//		dict.put(400, "DC");
//		dict.put(500, "D");
//		dict.put(900, "MC");
//		dict.put(1000, "M");
//	}
//
//	public String intToRoman(int num) {
//		StringBuilder sb = new StringBuilder();
//		int n = 1;
//		while (num != 0) {
//			int d = num % (n * 10);
//			num -= d;
//			if (d > 0) {
//				while (!dict.containsKey(d)) {
//					sb.append(dict.get(n));
//					d -= n;
//				}
//				sb.append(dict.get(d));
//			}
//			n *= 10;
//		}
//		return sb.reverse().toString();
//	}
	
	public String intToRoman(int num) {
	    String M[] = {"", "M", "MM", "MMM"};
	    String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
	    String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
	    String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	    return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
	}
	
	public static void main(String[] args) {
		IntegerToRoman itor = new IntegerToRoman();
		System.out.println(itor.intToRoman(1)); // I
		System.out.println(itor.intToRoman(96)); // XCVI
		System.out.println(itor.intToRoman(1954)); // MCMLIV
		System.out.println(itor.intToRoman(1990)); // MCMXC
		System.out.println(itor.intToRoman(2014)); // MMXIV
	}
}
