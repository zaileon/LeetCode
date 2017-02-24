import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {
	
	// if we see num % denom in the while loop, we are repeating digits
	// use map(remainder -> idx) to find the starting position of repetition part
	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0) return "0";
		
		StringBuilder sb = new StringBuilder();
		if (numerator < 0 ^ denominator < 0) sb.append("-");
		
		long num = Math.abs((long)numerator);
		long denom = Math.abs((long)denominator);
		sb.append(num / denom);
		
		num = num % denom;
		if (num == 0) return sb.toString();
		
		sb.append(".");
		Map<Long, Integer> map = new HashMap<>();
		while (num != 0) {
			map.put(num, sb.length());
			num *= 10;
			sb.append(num / denom);
			num %= denom;
			if (map.containsKey(num)) {
				sb.insert(map.get(num), "(");
				sb.append(")");
				break;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		FractionToDecimal fd = new FractionToDecimal();
		System.out.println(fd.fractionToDecimal(-1, Integer.MIN_VALUE)); // 0.0000000004656612873077392578125
		System.out.println(fd.fractionToDecimal(2, 1)); // 0.5
		System.out.println(fd.fractionToDecimal(1, 3)); // 0.5
		System.out.println(fd.fractionToDecimal(1, 2)); // 0.5
		System.out.println(fd.fractionToDecimal(1, 14)); // 0.0(714285)
		System.out.println(fd.fractionToDecimal(1, 101)); // 0.(0099)
	}

}
