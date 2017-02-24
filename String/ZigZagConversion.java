
public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if (numRows <= 1) return s;
		char[] cs = new char[s.length()];
		int row = 0, j = 0;
		while (row < numRows) {
			int step1 = 2 * (numRows - row - 1), step2 = 2 * row;
			for (int i = row; i < s.length();) {
				// row 0~numRows-1 need this block
				if (step1 > 0) {
					cs[j++] = s.charAt(i);
					i += step1;
				}
				// row 1~numRows need this block
				if (step2 > 0 && i < s.length()) {
					cs[j++] = s.charAt(i);
					i += step2;
				}
			}
			row++; 
		}
		return new String(cs);
	}

	public static void main(String[] args) {
		ZigZagConversion zzc = new ZigZagConversion();
		String s = "A"; int numRows = 1;
//		String s = "ABCDEFGHIJKL"; int numRows = 4;
		System.out.println(zzc.convert(s, numRows));
	}

}
